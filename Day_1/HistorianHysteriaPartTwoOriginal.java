package Day_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HistorianHysteriaPartTwoOriginal {
  public static void main(String[] args) {
    String filepath = "Day_1/day_1.csv";
    String line;

    int num;
    int score = 0;

    ArrayList<Integer> left_list = new ArrayList<>();
    ArrayList<Integer> right_list = new ArrayList<>();

    Map<Integer, Integer> occurrences = new HashMap<>();
  
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))) {
      while ((line = bufferedReader.readLine()) != null) {
        String[] values = line.split("\\s{3}"); // Split by 3 spaces, \\t for tabs

        left_list.add(Integer.parseInt(values[0]));
        right_list.add(Integer.parseInt(values[1]));
      }

      for (int i=0; i<right_list.size(); i++) {
        if (occurrences.containsKey(right_list.get(i))) {
          // int value;
          // value = occurrences.get(right_list[i]) +1;
          occurrences.replace(right_list.get(i), occurrences.get(right_list.get(i)) +1); // to avoid the extra variable
        } else {
          occurrences.put(right_list.get(i), 1);
        }
      }
      System.out.println("Occurrences Hash: " + occurrences);

      for (int i=0; i<left_list.size(); i++) {
        num = left_list.get(i);
        if (occurrences.containsKey(num)) {
          score = score + (num * occurrences.get(num));
        }
      }
  
      System.out.println("The similarity score is: " + score);
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
