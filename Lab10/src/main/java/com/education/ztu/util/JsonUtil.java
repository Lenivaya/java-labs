package com.education.ztu.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.education.ztu.game.Team;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Utility class for JSON operations with entities.
 */
public class JsonUtil {

  private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
  private static final Gson gson = new Gson();

  /**
   * Saves a list of Team items to a JSON file.
   *
   * @param teams    the list of Team items to save
   * @param fileName the name of the file to save to
   */
  public static void saveTeamsToJson(List<Team<?>> teams, String fileName) {
    try (FileWriter writer = new FileWriter(fileName)) {
      gson.toJson(teams, writer);
      logger.info("Teams saved to JSON file: {}", fileName);
    } catch (IOException e) {
      logger.error("Error saving teams to JSON", e);
    }
  }

  /**
   * Loads a list of Team items from a JSON file.
   *
   * @param fileName the name of the file to load from
   * @return the list of Team items loaded from the file
   */
  public static List<Team<?>> loadTeamsFromJson(String fileName) {
    try (FileReader reader = new FileReader(fileName)) {
      Type teamListType = new TypeToken<List<Team<?>>>() {}.getType();
      List<Team<?>> teams = gson.fromJson(reader, teamListType);
      logger.info("Teams loaded from JSON file: {}", fileName);
      return teams;
    } catch (IOException e) {
      logger.error("Error loading teams from JSON", e);
      return null;
    }
  }
}
