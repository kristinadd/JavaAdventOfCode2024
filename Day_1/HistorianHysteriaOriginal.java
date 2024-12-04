package Day_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HistorianHysteriaOriginal {

  public static void main(String[] args) {
    int result = 0;
    int difference;

    String filepath = "Day_1/day-1-part-1.csv";
    String line;

    ArrayList<Integer> old_list = new ArrayList<>();
    ArrayList<Integer> new_list = new ArrayList<>();
  
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))) {
      while ((line = bufferedReader.readLine()) != null) {
        String[] values = line.split("\\s{3}"); // Split by 3 spaces, \\t for tabs

        old_list.add(Integer.parseInt(values[0]));
        new_list.add(Integer.parseInt(values[1]));
      }
      old_list.sort(null); //  when it's null it's using natural order for sorting the elements
      new_list.sort(null);
      
      for (int i = 0; i < old_list.size(); i++) {
        difference = Math.abs(old_list.get(i) - new_list.get(i));
        result += difference;
      }
        System.out.println(result);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
