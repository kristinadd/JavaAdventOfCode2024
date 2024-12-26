package Day_3.AdvancedVersion;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstructionProcessor {

    public static ArrayList<Instruction> processInstructions(ArrayList<String> instructions) {
        ArrayList<Instruction> instructionList = new ArrayList<>();
        Pattern compiledPattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");

        for (String value : instructions) {
            Matcher matcher = compiledPattern.matcher(value);
            if (matcher.find()) {
                int firstNumber = Integer.parseInt(matcher.group(1));
                int secondNumber = Integer.parseInt(matcher.group(2));
                instructionList.add(new Instruction(firstNumber, secondNumber));
            } else {
                System.err.println("Invalid instruction format: " + value);
            }
        }
        return instructionList;
    }

    public static void processAndSum(ArrayList<Instruction> instructions) {
        int cumulativeSum = 0;

        for (int i = 0; i < instructions.size(); i++) {
            Instruction inst = instructions.get(i);
            int product = inst.getFirstNumber() * inst.getSecondNumber();
            cumulativeSum += product;

            System.out.printf("Instruction %d: %d * %d = %d%n", i + 1, inst.getFirstNumber(), inst.getSecondNumber(), product);
            System.out.printf("Cumulative Sum: %d%n", cumulativeSum);
        }

        System.out.printf("Final Cumulative Sum: %d%n", cumulativeSum);
    }
}
