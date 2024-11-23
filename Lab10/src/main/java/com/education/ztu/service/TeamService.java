package com.education.ztu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.education.ztu.game.Team;

/**
 * Service class for managing teams. It provides methods for adding, retrieving, updating, and deleting teams.
 */
public class TeamService {

  private static final Logger logger = LoggerFactory.getLogger(
    TeamService.class
  );
  private final Map<String, Team<?>> teamsMap;

  /**
   * Initializes the TeamService with an empty map to store teams.
   */
  public TeamService() {
    this.teamsMap = new HashMap<>();
  }

  /**
   * Adds a new team to the service.
   *
   * @param team the team to be added
   * @return this TeamService instance for method chaining
   */
  public TeamService addTeam(Team<?> team) {
    teamsMap.put(team.getName(), team);
    logger.debug("Added new team: {}", team);
    return this;
  }

  /**
   * Retrieves all teams managed by this service.
   *
   * @return a list of all teams
   */
  public List<Team<?>> getAllTeams() {
    return new ArrayList<>(teamsMap.values());
  }

  /**
   * Finds a team by its name.
   *
   * @param name the name of the team to find
   * @return an Optional containing the team if found, otherwise an empty Optional
   */
  public Optional<Team<?>> findTeamByName(String name) {
    return Optional.ofNullable(teamsMap.get(name));
  }

  /**
   * Updates an existing team.
   *
   * @param name the name of the team to update
   * @param updatedTeam the updated team information
   * @return true if the team was found and updated, false otherwise
   */
  public boolean updateTeam(String name, Team<?> updatedTeam) {
    if (teamsMap.containsKey(name)) {
      teamsMap.put(name, updatedTeam);
      logger.debug("Updated team: {}", updatedTeam);
      return true;
    }
    logger.debug("Team not found for update: {}", updatedTeam);
    return false;
  }

  /**
   * Deletes a team by its name.
   *
   * @param name the name of the team to delete
   * @return true if the team was found and deleted, false otherwise
   */
  public boolean deleteTeam(String name) {
    boolean removed = teamsMap.remove(name) != null;
    if (removed) {
      logger.debug("Deleted team with name: {}", name);
    } else {
      logger.debug("Team not found for deletion with name: {}", name);
    }
    return removed;
  }
}
