package com.education.ztu.game;

import java.util.Comparator;

/**
 * This class provides comparators for the Participant class.
 */
public class ParticipantComparators {

  /**
   * A comparator that compares participants by their age.
   */
  public static final Comparator<Participant> BY_AGE = Comparator.comparingInt(
    Participant::getAge
  );

  /**
   * A comparator that compares participants by their name, and then by their age if the names are the same.
   */
  public static final Comparator<Participant> BY_NAME_THEN_AGE =
    Comparator.comparing(Participant::getName).thenComparingInt(
      Participant::getAge
    );
}
