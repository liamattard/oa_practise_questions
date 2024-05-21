import java.util.HashMap;
import java.util.Map;

public class MinimumDeliveryTips {

  public static int findMinTrips(int[] packageWeight) {

    Map<Integer, Integer> sortedItems = new HashMap<>();
    int count = 0;

    for (int i : packageWeight) {
      sortedItems.put(i, sortedItems.getOrDefault(i, 0) + 1);
    }


    for (int i : sortedItems.values()) {

      if (i == 1) {
        return -1;
      }
      
      int remainderByThree = i % 3;
      int val = i;

      while (remainderByThree != 0) {
        val-=2;
        count ++;
        remainderByThree = val % 3;
      }

      count += val/3;
    }
      
    return count;
  }

  public static void main(String[] args) {
    int x = findMinTrips(new int[] {1,1,1,1,1,1,1,1});
    System.out.println(x);

  }
}
