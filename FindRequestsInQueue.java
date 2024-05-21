import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindRequestsInQueue {

  public static int[] findRequestsInQueue(int[] wait) {

    List<Integer> waitArrayList = Arrays.stream(wait)
        .boxed()
        .collect(Collectors.toList());

    List<Integer> x = new ArrayList<>();
    x.add(wait.length);

    for (int i = 1; i < wait.length; i++) {

      final int count = i;
      waitArrayList.remove(0);
      waitArrayList = waitArrayList.stream().filter(e -> e > count).collect(Collectors.toList());
      if (waitArrayList.isEmpty()) {
        x.add(0);
        break;
      } else {
        x.add(waitArrayList.size());
      }
    }

    return x.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    int[] x = findRequestsInQueue(new int[]{2,2,3,1});
    System.out.println(x);
  }
}
