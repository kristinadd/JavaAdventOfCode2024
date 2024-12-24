package Day_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MullItOver {
  static String filePath = "Day_3/test.csv";

  public static void main(String[] args) {
    ArrayList<String> instructions = processCSV(filePath);
    System.out.println(instructions);
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
}
