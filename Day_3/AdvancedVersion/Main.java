package Day_3.AdvancedVersion;

import java.util.ArrayList;
public class Main {
  public static void main(String [] args) {
    String filePath = "Day_3/day_3.csv";

    //  Move this part to the InstructionProcessor class
    // try {
    //   String content = Files.readString(Path.of(filePath));
    //   String pattern = "mul\\(\\d+,\\d+\\)";
    //   Pattern compiledPattern = Pattern.compile(pattern);
    //   Matcher matcher = compiledPattern.matcher(content);

    //   while (matcher.find()) {
    //     stringInstructions.add(matcher.group());
    //   }
      
    // } catch (IOException e) {
    //   e.printStackTrace();
    // }
    // System.out.println(stringInstructions);


   ArrayList<Instruction> instructions =  InstructionProcessor.processInstructions(filePath);
   InstructionProcessor.processAndSum(instructions);
  }
}
