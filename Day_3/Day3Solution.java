package Day_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Solution {

    public static void main(String[] args) {
        String filePath = "Day_3/day_3.csv";

        try {
            String memory = readInput(filePath);
            int result = sumMultiplicationsWithActivation(memory);
            System.out.println("Sum of multiplications with activation: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readInput(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }

    // PART 1: Calculate the sum of valid multiplications
    public static int sumMultiplications(String memory) {
        String pattern = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(memory);

        int total = 0;
        while (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            total += x * y;
        }
        return total;
    }

    // PART 2: Remove inactive memory based on "do()" and "don't()"
    public static String removeInactiveMemory(String memory) {
        StringBuilder filteredMemory = new StringBuilder();

        // Split the memory into segments based on "do()"
        String[] segments = memory.split("do\\(\\)");

        for (String segment : segments) {
            // Keep only the part before "don't()" in each segment
            if (!segment.contains("don't()")) {
                filteredMemory.append(segment);
            } else {
                filteredMemory.append(segment.split("don't\\(\\)")[0]);
            }
        }

        return filteredMemory.toString();
    }

    // PART 2: Combine memory filtering and summing logic
    public static int sumMultiplicationsWithActivation(String memory) {
        String filteredMemory = removeInactiveMemory(memory);
        return sumMultiplications(filteredMemory);
    }
}
