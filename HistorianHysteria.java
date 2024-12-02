import java.util.Arrays;

public class HistorianHysteria {

  public static int historinHisteria(int[] old_list, int[] new_list) {
    Arrays.sort(old_list);
    Arrays.sort(new_list);
    int result = 0;
    int difference = 0;

    for(int i=0; i< old_list.length; i++) {
      
      if (old_list[i] >= new_list[i]) {
        difference = old_list[i] - new_list[i];
      } else {
        difference = new_list[i] - old_list[i];
      }
      result = result + difference;
    }
    return result;
  }
  public static void main(String[] args) {

    int[] old_list = {3,4,2,1,3,3};
    int[] new_list = {4,3,5,3,9,3};

    int result = historinHisteria(old_list, new_list);

    System.out.println(result);
  }
}
