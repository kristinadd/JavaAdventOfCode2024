package Day_1;

import java.util.HashMap;
import java.util.Map;

public class HistorianHysteriaPartTwoMini {
  public static void main(String[] args) {
    int[] left_list = {3,4,2,1,3,3};
    int[] right_list = {4,3,5,3,9,3};

    int num;
    int score = 0;

    Map<Integer, Integer> occurrences = new HashMap<>();

    for (int i=0; i<right_list.length; i++) {
      if (occurrences.containsKey(right_list[i])) {
        // int value;
        // value = occurrences.get(right_list[i]) +1;
        occurrences.replace(right_list[i], occurrences.get(right_list[i]) +1); // to avoid the extra variable
      } else {
        occurrences.put(right_list[i], 1);
      }
    }
    System.out.println(occurrences);

    for (int i=0; i<left_list.length; i++) {
      num = left_list[i];
      if (occurrences.containsKey(num)) {
        score = score + (num * occurrences.get(num));
      }
    }

    System.out.println(score);
  }
}
