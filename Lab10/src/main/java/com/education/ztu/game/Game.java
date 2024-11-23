package com.education.ztu.game;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a game entity in the game management system.
 * This class implements Serializable for persistence and XML serialization support.
 *
 * @see Serializable
 */
public class Game implements Serializable {

  @Serial
  private static final long serialVersionUID = -8483676230754379492L;

  private UUID id;

  private String name;

  private String description;

  private transient LocalDateTime lastAccessed;

  /**
   * Default constructor required for JAXB XML serialization.
   */
  public Game() {
    this.setId(UUID.randomUUID());
  }

  /**
   * Creates a new game with specified name.
   *
   * @param name the name of the game
   */
  public Game(String name) {
    this.setId(UUID.randomUUID()).setName(name);
  }

  /**
   * Gets the unique identifier of the game.
   *
   * @return the UUID of the game
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets the unique identifier of the game.
   *
   * @param id the UUID to set
   * @return this Game instance for method chaining
   */
  public Game setId(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Gets the name of the game.
   *
   * @return the name of the game
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the game.
   *
   * @param name the name to set
   * @return this Game instance for method chaining
   */
  public Game setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Gets the description of the game.
   *
   * @return the description of the game
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description of the game.
   *
   * @param description the description to set
   * @return this Game instance for method chaining
   */
  public Game setDescription(String description) {
    this.description = description;
    return this;
  }

  /**
   * Gets the last accessed date and time of the game.
   *
   * @return the last accessed date and time
   */
  public LocalDateTime getLastAccessed() {
    return lastAccessed;
  }

  /**
   * Sets the last accessed date and time of the game.
   *
   * @param lastAccessed the last accessed date and time to set
   * @return this Game instance for method chaining
   */
  public Game setLastAccessed(LocalDateTime lastAccessed) {
    this.lastAccessed = lastAccessed;
    return this;
  }

  @Override
  public String toString() {
    return (
      "Game{" +
      "id=" +
      id +
      ", name='" +
      name +
      '\'' +
      ", description='" +
      description +
      '\'' +
      ", lastAccessed=" +
      lastAccessed +
      '}'
    );
  }
}
