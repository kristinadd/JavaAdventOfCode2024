package Day_2;

import java.util.Arrays;

public class RedNosedReports {
  public static void main(String[] args) {
      String[] reports = { 
          "7 6 4 2 1", 
          "1 2 7 8 9", 
          "9 7 6 2 1", 
          "1 3 2 4 5", 
          "8 6 4 4 1", 
          "1 3 6 7 9" 
      };

      int safeReports = 0;

      for (String report : reports) {
          int[] levels = parseLevels(report);
          if (isSafe(levels)) {
              System.out.println(report + ": Safe because the levels are all " +
                  (isIncreasing(levels) ? "increasing" : "decreasing") + " by 1, 2, or 3.");
              safeReports++;
          } else {
              System.out.println(report + ": Unsafe.");
          }
      }

      System.out.println("So, in this example, " + safeReports + " reports are safe.");
  }

  // Parse a space-separated string of numbers into an integer array
  public static int[] parseLevels(String report) {
      String[] parts = report.split(" ");
      int[] levels = new int[parts.length];
      for (int i = 0; i < parts.length; i++) {
          levels[i] = Integer.parseInt(parts[i]);
      }
      return levels;
  }

  // Check if the array is safe
  public static boolean isSafe(int[] levels) {
      if (levels == null || levels.length < 2) {
          return false; // Invalid or too short
      }

      // Determine if it's increasing or decreasing
      boolean increasing = isIncreasing(levels);
      boolean decreasing = isDecreasing(levels);

      // Must be strictly increasing or decreasing with differences <= 3
      return (increasing || decreasing) && hasValidDifferences(levels);
  }

  // Check if the array is strictly increasing
  public static boolean isIncreasing(int[] levels) {
      for (int i = 1; i < levels.length; i++) {
          if (levels[i] <= levels[i - 1]) { // Not strictly increasing
              return false;
          }
      }
      return true;
  }

  // Check if the array is strictly decreasing
  public static boolean isDecreasing(int[] levels) {
      for (int i = 1; i < levels.length; i++) {
          if (levels[i] >= levels[i - 1]) { // Not strictly decreasing
              return false;
          }
      }
      return true;
  }

  // Check if all differences are <= 3
  public static boolean hasValidDifferences(int[] levels) {
      for (int i = 1; i < levels.length; i++) {
          int diff = Math.abs(levels[i] - levels[i - 1]);
          if (diff > 3) { // Difference exceeds 3
              return false;
          }
      }
      return true;
  }
}
