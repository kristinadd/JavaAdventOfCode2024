// package Day_2;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// public class RedNosedReportsPartOne {
//   public static void main(String[] args) {
//     String[] reports = { "7 6 4 2 1", "1 2 7 8 9", "9 7 6 2 1", "1 3 2 4 5", "8 6 4 4 1", "1 3 6 7 9" };

//     String[][] levels = new String[reports.length][];
//     // Because the second dimension is an array, and Java supports flexible (ragged/jagged) arrays. 
//     // Each row can have a different size, so the second dimension doesn’t need to be specified upfront.

//     // Because the second dimension is not allocated until you assign a specific array to that row. 
//     // The first dimension array (of references) must have a fixed size up front—otherwise, 
//     // Java wouldn’t even know how many references to hold. But each of those references can later 
//     // point to a new array of any length. You get to decide that length at runtime, on a per-row basis.

//     // If you think about it step-by-step:
//     // Without a first dimension: You have no array at all. Java needs a number to know how many 
//     // references to allocate in memory. So you must specify the size of the first dimension.

//     // Without specifying the second dimension: That’s okay. Each element of your newly created 
//     // first-dimension array is just a reference. Until you create and assign an actual array to 
//     // that reference, Java doesn’t need to know how long that array will be. You’re free to choose it later.

//     for (int i=0; i<reports.length; i++) {
//       levels[i] = reports[i].split(" "); // dynamic creation of the inner array
//       // reports[i].split(" ") returns a new String[] array that is dynamically created by the split() method.
//       // In Java, arrays are objects, and assigning levels[i] = ... simply assigns a reference to the newly created String[] object
//       // No explicit new keyword is needed here because split(" ") already creates the array for you.
//     }

//     int[][] intLevels = new int[reports.length][];

//     for (int i=0; i<reports.length; i++) {
//       intLevels[i] = new int[levels[i].length]; // create length
//       for (int j=0; j<intLevels[i].length; j++) {
//         intLevels[i][j] = Integer.parseInt(levels[i][j]);
//       }
//       System.out.println(Arrays.toString(intLevels[i]));
//     }

//     for (int[] row : intLevels) {
//       isIncreasing(row);
//       isDecreasing(row);
//     }
//   }

//   public static boolean isIncreasing(int[] row) {
//       for (int j=1; j<row.length; j++) {
//         if (row[j] <= row[j -1]) {
//           System.out.println("Row " + j + " is not increasing!");
//           return false;
//         }
//       }
//     System.out.println("The row is increasing");
//     return true;
//   }

//   public static boolean isDecreasing(int[] row) {
//     for (int j=1; j<row.length; j++) {
//       if (row[j] >= row[j -1]) {
//         System.out.println("Row " + j + " is not decreasing!");
//         return false;
//       }
//     }
//   System.out.println("The row is decreasing");
//   return true;
//   }

// }

package Day_2;

import java.util.Arrays;

public class RedNosedReportsPartOne {
    public static void main(String[] args) {
        String[] reports = { 
            "7 6 4 2 1", 
            "1 2 7 8 9", 
            "9 7 6 2 1", 
            "1 3 2 4 5", 
            "8 6 4 4 1", 
            "1 3 6 7 9" 
        };

        int[][] intLevels = new int[reports.length][];

        // Parse the input into a 2D array of integers
        for (int i = 0; i < reports.length; i++) {
            intLevels[i] = Arrays.stream(reports[i].split(" "))
                                  .mapToInt(Integer::parseInt)
                                  .toArray();
        }

        // Count the number of safe rows
        int safeReportsCount = 0;
        for (int[] row : intLevels) {
            if (isSafe(row)) {
                safeReportsCount++;
            }
        }

        System.out.println("Number of safe reports: " + safeReportsCount);
    }

    /**
     * Checks if a report is safe.
     *
     * @param row The array of integers to check.
     * @return True if the report is safe, otherwise false.
     */
    public static boolean isSafe(int[] row) {
        if (row.length < 2) return false;

        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < row.length; i++) {
            int diff = row[i] - row[i - 1];

            if (diff < 1 || diff > 3) {
                return false; // Not within the allowed difference range
            }

            if (row[i] < row[i - 1]) {
                increasing = false;
            }
            if (row[i] > row[i - 1]) {
                decreasing = false;
            }
        }

        // A row is safe if it's either all increasing or all decreasing
        return increasing || decreasing;
    }
}
