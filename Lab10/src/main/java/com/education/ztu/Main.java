package com.education.ztu;

import com.education.ztu.game.Employee;
import com.education.ztu.game.Team;
import com.education.ztu.service.TeamService;
import com.education.ztu.util.JsonUtil;
import com.education.ztu.util.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public class Main {

  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    logger.info("Starting Game Management application");

    var teamService = new TeamService();

    var chessTeam = new Team<>("Chess Team");
    chessTeam.addNewParticipants(
      List.of(
        new Employee("John", 30),
        new Employee("Jane", 25),
        new Employee("Jim", 35),
        new Employee("Jill", 30)
      )
    );

    var anotherChessTeam = new Team<>("Another Chess Team");
    anotherChessTeam.addNewParticipants(
      List.of(
        new Employee("John", 30),
        new Employee("Jane", 25),
        new Employee("Jim", 35),
        new Employee("Jill", 30)
      )
    );

    var pokerTeam = new Team<>("Poker Team");
    pokerTeam.addNewParticipants(
      List.of(
        new Employee("John", 30),
        new Employee("Jane", 25),
        new Employee("Jim", 35),
        new Employee("Jill", 30)
      )
    );

    logger.debug("Adding new teams to the system");
    teamService.addTeam(chessTeam).addTeam(anotherChessTeam).addTeam(pokerTeam);

    logger.info("Current teams:");
    teamService.getAllTeams().forEach(team -> logger.info(team.toString()));

    // update a team
    var updatedTeam = new Team<>("Updated Chess Team");
    updatedTeam.addNewParticipants(
      List.of(new Employee("Alice", 28), new Employee("Bob", 32))
    );
    teamService.updateTeam(
      teamService.getAllTeams().get(0).getName(),
      updatedTeam
    );
    logger.debug("Team updated: {}", updatedTeam);

    // xml
    try {
      logger.info("Saving teams to XML");
      XmlUtil.saveTeamsToXml(teamService.getAllTeams(), "teams.xml");

      logger.info("Loading teams from XML");
      var loadedFromXml = XmlUtil.loadTeamsFromXml("teams.xml");

      logger.info("Teams loaded from XML:");
      loadedFromXml.forEach(team -> logger.info(team.toString()));
    } catch (Exception e) {
      logger.trace("Stack trace: {}", e.getStackTrace().toString());
      logger.error("Error processing XML: {}", e.getMessage(), e);
    }

    // json
    try {
      logger.info("Saving teams to JSON");
      JsonUtil.saveTeamsToJson(teamService.getAllTeams(), "teams.json");

      logger.info("Loading teams from JSON");
      List<Team<?>> loadedFromJson = JsonUtil.loadTeamsFromJson("teams.json");

      logger.info("Teams loaded from JSON:");
      Objects.requireNonNull(loadedFromJson).forEach(team ->
        logger.info(team.toString())
      );
    } catch (Exception e) {
      logger.error("Error processing JSON: {}", e.getMessage(), e);
    }
  }
}
