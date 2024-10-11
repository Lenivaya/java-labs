package com.education.ztu.game;

import java.util.Comparator;

public class ParticipantComparators {

  public static final Comparator<Participant> BY_AGE = Comparator.comparingInt(
    Participant::getAge
  );

  public static final Comparator<Participant> BY_NAME_THEN_AGE =
    Comparator.comparing(Participant::getName).thenComparingInt(
      Participant::getAge
    );
}
