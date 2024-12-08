package Day_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedNosedReportsPartOne {
  public static void main(String[] args) {
    String[] reports = { "7 6 4 2 1", "1 2 7 8 9", "9 7 6 2 1", "1 3 2 4 5", "8 6 4 4 1", "1 3 6 7 9" };

    // List<String> levels = new ArrayList<>();

    // for (int i=0; i<reports.length; i++) {
    //   System.out.println(reports[i]);
    //   levels = Arrays.asList(reports[i].split(" "));
    // }

    String report = reports[0];
    String[] levels = report.split(" ");
    System.out.println(Arrays.toString(levels));

    int[] intLevels = new int[levels.length];

    for (int i=0; i<levels.length; i++) {
      intLevels[i] = Integer.parseInt(levels[i]);
    }
    System.out.println(Arrays.toString(intLevels));
    
  }
}

