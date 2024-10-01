package com.education.ztu;

public class Car {

  public class Engine {

    private boolean engineWorks;

    public void startEngine() {
      engineWorks = true;
    }

    public void stopEngine() {
      engineWorks = false;
    }

    public boolean isEngineWorks() {
      return engineWorks;
    }
  }

  public String brand;
  private Engine engine;

  public boolean engineIsRunning() {
    return engine.isEngineWorks();
  }
}
