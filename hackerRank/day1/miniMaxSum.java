package day1;
import java.util.List;
import java.util.stream.Collectors;

public class miniMaxSum {

  public static long getSumOfLongs(List<Long> list){
    return list.stream().mapToLong(Long::longValue).sum();
  }

  public static void findMiniMaxSum(List<Integer> arr) {

    List<Long> sortedList = arr.stream().sorted().map(Integer::toUnsignedLong).collect(Collectors.toList());
    long sumOfSmallestFour = getSumOfLongs(sortedList.subList(0, 4));
    long sumOfLargestFour = getSumOfLongs(sortedList.subList(1, 5));

    System.out.printf("%d %d", sumOfSmallestFour, sumOfLargestFour);
  }

  public static void main(String[] args) {
    // findMiniMaxSum(List.of(1, 7, 3, 2, 1));
    findMiniMaxSum(List.of(769082435, 210437958, 673982045, 375809214, 380564127));
  }

}
