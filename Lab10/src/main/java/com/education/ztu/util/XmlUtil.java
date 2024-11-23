package com.education.ztu.util;

import com.education.ztu.game.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.*;

/**
 * Utility class for XML operations with entities using DOM.
 */
public final class XmlUtil {

  private static final Logger logger = LoggerFactory.getLogger(XmlUtil.class);
  private static final Map<
    String,
    Class<? extends Participant>
  > PARTICIPANT_TYPES = Map.of(
    "employee",
    Employee.class,
    "student",
    Student.class,
    "scholar",
    Scholar.class
  );

  private XmlUtil() {
    throw new AssertionError("Utility class should not be instantiated");
  }

  /**
   * Saves a list of Team objects to an XML file.
   *
   * @param teams    the list of Team objects to save
   * @param fileName the name of the file to save to
   * @throws RuntimeException if there's an error during XML processing
   */
  public static void saveTeamsToXml(List<Team<?>> teams, String fileName) {
    validateInputs(teams, fileName);

    try {
      var doc = createDocument();
      var rootElement = createRootElement(doc);

      teams
        .stream()
        .filter(Objects::nonNull)
        .forEach(team -> addTeamToXml(doc, rootElement, team));

      writeDocumentToFile(doc, fileName);
      logger.info(
        "Successfully saved {} teams to XML file: {}",
        teams.size(),
        fileName
      );
    } catch (Exception e) {
      throw new XmlProcessingException("Failed to save teams to XML", e);
    }
  }

  /**
   * Loads a list of Team objects from an XML file.
   *
   * @param fileName the name of the file to load from
   * @return the list of Team objects loaded from the file
   * @throws RuntimeException if there's an error during XML processing
   */
  public static List<Team<?>> loadTeamsFromXml(String fileName) {
    try {
      var doc = parseXmlFile(fileName);
      var teamNodes = doc.getElementsByTagName("team");
      var teams = new ArrayList<Team<?>>();

      for (int i = 0; i < teamNodes.getLength(); i++) {
        var teamElement = (Element) teamNodes.item(i);
        var team = createTeamFromElement(teamElement);
        teams.add(team);
      }

      logger.info("Teams loaded from XML file: {}", fileName);
      return teams;
    } catch (Exception e) {
      logger.error("Error loading teams from XML", e);
      return Collections.emptyList();
    }
  }

  private static Document createDocument() throws Exception {
    var factory = DocumentBuilderFactory.newInstance();
    var builder = factory.newDocumentBuilder();
    return builder.newDocument();
  }

  private static Element createRootElement(Document doc) {
    var rootElement = doc.createElement("teams");
    doc.appendChild(rootElement);
    return rootElement;
  }

  private static void addTeamToXml(
    Document doc,
    Element rootElement,
    Team<?> team
  ) {
    var teamElement = doc.createElement("team");

    Optional.ofNullable(team.getName()).ifPresentOrElse(
      name -> appendTextElement(doc, teamElement, "name", name),
      () -> logger.warn("Team name is null")
    );

    var participantsElement = doc.createElement("participants");
    team
      .getParticipants()
      .stream()
      .filter(Objects::nonNull)
      .forEach(participant ->
        addParticipantToXml(doc, participantsElement, participant)
      );

    teamElement.appendChild(participantsElement);
    rootElement.appendChild(teamElement);
  }

  private static void addParticipantToXml(
    Document doc,
    Element participantsElement,
    Participant participant
  ) {
    var elementName = participant.getClass().getSimpleName().toLowerCase();
    var participantElement = doc.createElement(elementName);

    appendTextElement(doc, participantElement, "name", participant.getName());
    appendTextElement(
      doc,
      participantElement,
      "age",
      String.valueOf(participant.getAge())
    );

    participantsElement.appendChild(participantElement);
  }

  private static void appendTextElement(
    Document doc,
    Element parent,
    String elementName,
    String content
  ) {
    var element = doc.createElement(elementName);
    element.setTextContent(content);
    parent.appendChild(element);
  }

  private static void writeDocumentToFile(Document doc, String fileName)
    throws Exception {
    var transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty(
      "{http://xml.apache.org/xslt}indent-amount",
      "2"
    );

    transformer.transform(
      new DOMSource(doc),
      new StreamResult(new File(fileName))
    );
  }

  private static Document parseXmlFile(String fileName) throws Exception {
    var factory = DocumentBuilderFactory.newInstance();
    var builder = factory.newDocumentBuilder();
    var doc = builder.parse(new File(fileName));
    doc.getDocumentElement().normalize();
    return doc;
  }

  private static Team<?> createTeamFromElement(Element teamElement) {
    var teamName = getElementTextContent(teamElement, "name");
    var team = new Team<>(teamName);

    Optional.ofNullable(
      teamElement.getElementsByTagName("participants").item(0)
    )
      .map(Element.class::cast)
      .ifPresent(participantsElement ->
        PARTICIPANT_TYPES.forEach((type, clazz) ->
          addParticipantsOfType(participantsElement, type, clazz, team)
        )
      );

    return team;
  }

  private static String getElementTextContent(Element element, String tagName) {
    return element.getElementsByTagName(tagName).item(0).getTextContent();
  }

  @SuppressWarnings("unchecked")
  private static <T extends Participant> void addParticipantsOfType(
    Element participantsElement,
    String elementName,
    Class<T> participantClass,
    Team<?> team
  ) {
    var participants = participantsElement.getElementsByTagName(elementName);

    for (int i = 0; i < participants.getLength(); i++) {
      var participantElement = (Element) participants.item(i);
      createParticipant(participantElement, participantClass).ifPresent(
        participant -> ((Team<T>) team).addNewParticipant(participant)
      );
    }
  }

  private static <T extends Participant> Optional<T> createParticipant(
    Element element,
    Class<T> participantClass
  ) {
    try {
      var name = getElementTextContent(element, "name");
      var age = Integer.parseInt(getElementTextContent(element, "age"));

      var constructor = participantClass.getConstructor(
        String.class,
        int.class
      );
      return Optional.of(constructor.newInstance(name, age));
    } catch (Exception e) {
      logger.error(
        "Error creating participant of type: {}",
        participantClass.getSimpleName(),
        e
      );
      return Optional.empty();
    }
  }

  private static void validateInputs(List<Team<?>> teams, String fileName) {
    if (teams == null) {
      throw new IllegalArgumentException("Teams list cannot be null");
    }
    if (StringUtils.isBlank(fileName)) {
      throw new IllegalArgumentException("File name cannot be blank");
    }
  }

  public static class XmlProcessingException extends RuntimeException {

    public XmlProcessingException(String message, Throwable cause) {
      super(message, cause);
    }
  }
}
