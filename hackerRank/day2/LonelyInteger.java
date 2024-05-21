package day2;

import java.util.List;
import java.util.stream.Collectors;

public class LonelyInteger {

  public static int lonelyinteger(List<Integer> a) {
    a.remove(0);

    int sumOfTheSet = a.stream().collect(Collectors.toSet()).stream().mapToInt(Integer::intValue).sum();

    int sumOfTheList = a.stream().mapToInt(Integer::intValue).sum();

    return (sumOfTheSet * 2) - sumOfTheList;
  }

  public static void main(String[] args) {

    for (int i = 0; i < 3; i++) {
      System.out.println("aaa "+i);
      
    }
    int lonelyinteger = lonelyinteger(List.of(1, 2, 3, 4, 3, 2, 1));
    System.out.println(lonelyinteger);

  }
}
