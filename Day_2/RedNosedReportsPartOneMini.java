package Day_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
  
  public class RedNosedReportsPartOneMini {
  
    public static void main(String[] args) {

        String[] inputReports = {
            "7 6 4 2 1",
            "1 2 7 8 9",
            "9 7 6 2 1",
            "1 3 2 4 5",
            "8 6 4 4 1",
            "1 3 6 7 9"
        };

        List<int[]> reports = parseReports(inputReports);

        int safeCount = 0;
        for (int[] report : reports) {
            if (isSafe(report)) {
                safeCount++;
            }
        }

        System.out.println("Number of safe reports: " + safeCount);
    }

    private static List<int[]> parseReports(String[] inputReports) {
        List<int[]> reports = new ArrayList<>();
        for (String report : inputReports) {
            reports.add(Arrays.stream(report.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray());
        }
        return reports;
    }

    private static boolean isSafe(int[] report) {
        if (report.length < 2) return false; // A single number can't be increasing or decreasing

        boolean isIncreasing = report[1] > report[0];
        for (int i = 1; i < report.length; i++) {
            int diff = report[i] - report[i - 1];

            if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                return false;
            }

            if ((diff > 0 && !isIncreasing) || (diff < 0 && isIncreasing)) {
                return false;
            }
        }
        return true;
    }
}
