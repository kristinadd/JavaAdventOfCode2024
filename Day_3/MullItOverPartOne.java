package Day_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MullItOverPartOne {
  static String filePath = "Day_3/day_3.csv";

  public static void main(String[] args) {
    ArrayList<String> instructions = processCSV(filePath);
    // System.out.println(instructions);
    String [][] stringInstructions = processInstructions(instructions);
    System.out.println(processInstructions(instructions).length);
    // System.out.println(Arrays.toString(stringInstructions[0]));
    convertInstructionsToInt(stringInstructions);
    processAndSum(convertInstructionsToInt(stringInstructions));
  }

  public static ArrayList<String> processCSV(String filePath) {
    ArrayList<String> instructions = new ArrayList<>();
    try {
      String content = Files.readString(Path.of(filePath));
      String pattern = "mul\\(\\d+,\\d+\\)";
      Pattern compiledPattern = Pattern.compile(pattern);
      Matcher matcher = compiledPattern.matcher(content);

      while (matcher.find()) {
        // In Java's Matcher class, the group() method is used to retrieve the part of the input string that matches the specified pattern.
        // System.out.println(matcher.group());
        instructions.add(matcher.group()); // returns string 
      }
      // System.out.println(instructions.get(10).getClass().getName());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return instructions;
  }

  public static String[][] processInstructions(ArrayList<String> instructions) {
    String[][] processedInstructions = new String[instructions.size()][];
    for (int i=0; i < instructions.size(); i++) {
      String value = instructions.get(i);
      String pattern = "mul\\((\\d+),(\\d+)\\)"; // each () is a different group
      Pattern compiledPattern = Pattern.compile(pattern);
      Matcher matcher = compiledPattern.matcher(value);
      if (matcher.find()) {
        processedInstructions[i] = new String[2];
        processedInstructions[i][0] = matcher.group(1);
        processedInstructions[i][1] = matcher.group(2);
        System.out.println(Arrays.toString(processedInstructions[i]));
      }
    } 
    return processedInstructions;
  }

  public static int[][][] convertInstructionsToInt(String[][] processedInstructions) {
    // Initialize the 3D array of integers
    int[][][] intInstructions = new int[processedInstructions.length][2][1];

    // Loop through the 2D array and populate the 3D array
    for (int i = 0; i < processedInstructions.length; i++) {
        for (int j = 0; j < 2; j++) { // 2 because each processedInstruction has two numbers
            try {
                // Convert string to int and store in 3D array
                intInstructions[i][j][0] = Integer.parseInt(processedInstructions[i][j]);
            } catch (NumberFormatException e) {
                // Handle invalid string conversion gracefully
                intInstructions[i][j][0] = -1; // Default value for invalid input
                System.err.println("Invalid number: " + processedInstructions[i][j]);
            }
        }
    }

    // Print the 3D array for debugging
    // for (int[][] outerArray : intInstructions) {
    //     for (int[] innerArray : outerArray) {
    //         System.out.print("[" + innerArray[0] + "] ");
    //     }
    //     System.out.println();
    // }
    // System.out.println(Arrays.deepToString(intInstructions));
    return intInstructions;
  }

  public static void processAndSum(int[][][] intInstructions) {
    int cumulativeSum = 0;

    for (int i = 0; i < intInstructions.length; i++) {
        // Extract the two numbers from the current instruction
        int firstNumber = intInstructions[i][0][0];
        int secondNumber = intInstructions[i][1][0];

        // Multiply the two numbers
        int product = firstNumber * secondNumber;

        // Add the product to the cumulative sum
        cumulativeSum += product;

        // Print the current product and cumulative sum
        // System.out.println("Instruction " + (i + 1) + ": " + firstNumber + " * " + secondNumber + " = " + product);
        // System.out.println("Cumulative Sum: " + cumulativeSum);
    }

    // Final cumulative sum
    System.out.println("Final Cumulative Sum: " + cumulativeSum);
  }

}
