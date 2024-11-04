package com.education.ztu;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Task7 {

  private static final int ARRAY_SIZE = 1_000_000;
  private static final int NUM_THREADS = 5;
  private static final int[] numbers = new int[ARRAY_SIZE];
  private static final int DEFAULT_LOWER_BOUND = 0;
  private static final int DEFAULT_UPPER_BOUND = 999;

  public static void main(String[] args) throws Exception {
    var scanner = new Scanner(System.in);

    int lowerBound = getInput(
      scanner,
      "Enter lower bound for random numbers (default is 0): ",
      DEFAULT_LOWER_BOUND
    );
    int upperBound = getInput(
      scanner,
      "Enter upper bound for random numbers (default is 999): ",
      DEFAULT_UPPER_BOUND
    );

    initializeArray(lowerBound, upperBound);

    measureExecutionTime("Single-threaded sum", Task7::singleThreadedSum);
    measureExecutionTime("Multi-threaded sum", Task7::multiThreadedSum);

    scanner.close();
  }

  private static int getInput(
    Scanner scanner,
    String prompt,
    int defaultValue
  ) {
    System.out.print(prompt);
    var input = scanner.nextLine();
    return input.isEmpty() ? defaultValue : Integer.parseInt(input);
  }

  private static void initializeArray(int lowerBound, int upperBound) {
    var random = new Random();
    IntStream.range(0, ARRAY_SIZE)
      .parallel()
      .forEach(i ->
        numbers[i] = random.nextInt(upperBound - lowerBound + 1) + lowerBound
      );
  }

  private static void measureExecutionTime(
    String description,
    Callable<Long> task
  ) throws Exception {
    long startTime = System.nanoTime();
    long result = task.call();
    long endTime = System.nanoTime();
    System.out.printf("%s: %d%n", description, result);
    System.out.printf(
      "Execution time: %.3f ms%n",
      (endTime - startTime) / 1_000_000.0
    );
  }

  private static long singleThreadedSum() {
    return IntStream.of(numbers).mapToLong(Task7::sumOfDigits).sum();
  }

  private static long multiThreadedSum() /**/{
    var executorService = Executors.newFixedThreadPool(NUM_THREADS);
    var chunkSize = ARRAY_SIZE / NUM_THREADS;

    try {
      var tasks = IntStream.range(0, NUM_THREADS)
        .mapToObj(i -> {
          int start = i * chunkSize;
          int end = (i == NUM_THREADS - 1) ? ARRAY_SIZE : start + chunkSize;
          return new DigitSumCallable(Arrays.copyOfRange(numbers, start, end));
        })
        .toList();

      return executorService
        .invokeAll(tasks)
        .stream()
        .mapToLong(future -> {
          try {
            return future.get();
          } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
          }
        })
        .sum();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException("Error in multiThreadedSum", e);
    } finally {
      executorService.shutdown();
    }
  }

  private static int sumOfDigits(int number) {
    int sum = 0;
    while (number > 0) {
      sum += number % 10;
      number /= 10;
    }
    return sum;
  }

  static class DigitSumCallable implements Callable<Long> {

    private final int[] chunk;

    DigitSumCallable(int[] chunk) {
      this.chunk = chunk;
    }

    @Override
    public Long call() {
      return Arrays.stream(chunk).mapToLong(Task7::sumOfDigits).sum();
    }
  }
}
