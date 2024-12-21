package Day_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Testing {
    public static void main(String[] args) {
        String filePath = "Day_2/day_2.csv"; // Path to your CSV file
        List<int[]> reports = readReportsFromFile(filePath);

        if (reports == null) {
            System.out.println("Error reading the file. Exiting.");
            return;
        }

        int safeReports = 0;

        for (int[] levels : reports) {
            if (isSafe(levels)) {
                System.out.println(arrayToString(levels) + ": Safe because the levels are all " +
                    (isIncreasing(levels) ? "increasing" : "decreasing") + " by 1, 2, or 3.");
                safeReports++;
            } else {
                System.out.println(arrayToString(levels) + ": Unsafe.");
            }
        }

        System.out.println("So, in this example, " + safeReports + " reports are safe.");
    }

    // Reads reports from a CSV file and converts them into a list of integer arrays
    public static List<int[]> readReportsFromFile(String filePath) {
        List<int[]> reports = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                if (!line.trim().isEmpty()) { // Skip empty lines
                    String[] parts = line.split(" ");
                    int[] levels = new int[parts.length];
                    for (int i = 0; i < parts.length; i++) {
                        levels[i] = Integer.parseInt(parts[i].trim());
                    }
                    reports.add(levels);
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read the file: " + e.getMessage());
            return null;
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number in the file: " + e.getMessage());
            return null;
        }
        return reports;
    }

    // Converts an integer array to a space-separated string for display
    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }

    // Checks if the array is safe
    public static boolean isSafe(int[] levels) {
        if (levels == null || levels.length < 2) {
            return false; // Invalid or too short
        }

        boolean increasing = isIncreasing(levels);
        boolean decreasing = isDecreasing(levels);

        return (increasing || decreasing) && hasValidDifferences(levels);
    }

    // Checks if the array is strictly increasing
    public static boolean isIncreasing(int[] levels) {
        for (int i = 1; i < levels.length; i++) {
            if (levels[i] <= levels[i - 1]) { // Not strictly increasing
                return false;
            }
        }
        return true;
    }

    // Checks if the array is strictly decreasing
    public static boolean isDecreasing(int[] levels) {
        for (int i = 1; i < levels.length; i++) {
            if (levels[i] >= levels[i - 1]) { // Not strictly decreasing
                return false;
            }
        }
        return true;
    }

    // Checks if all differences are within the allowed range
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
