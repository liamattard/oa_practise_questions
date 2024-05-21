package day2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FlippingMatrix {

  public static int findMax(List<List<Integer>> matrix) {

    // int quadrantSize = matrix.get(1).get(0);
    int quadrantSize = matrix.size() / 2;
    // matrix.remove(0);
    // matrix.remove(0);

    int matrixSize = matrix.size() - 1;

    List<Integer> quadrantVals = new ArrayList<>();
    System.err.println("Quadrant size: " + quadrantSize);

    for (int i = 0; i < quadrantSize; i++) {
      for (int j = 0; j < quadrantSize; j++) {
        int valueOne = matrix.get(i).get(j);
        System.err.println("ValOne: " + valueOne);

        int valueTwo = matrix.get(i).get(matrixSize - j);
        System.err.println("ValTwo: " + valueTwo);

        int valueThree = matrix.get(matrixSize - i).get(j);
        System.err.println("ValThree: " + valueThree);

        int valueFour = matrix.get(matrixSize - i).get(matrixSize - j);
        System.err.println("ValFour: " + valueFour);
        System.err.println("------");

        quadrantVals.add(Stream.of(valueOne, valueTwo, valueThree, valueFour).max(Integer::compareTo).get());
      }
    }

    return quadrantVals.stream().mapToInt(Integer::intValue).sum();

  }

  public static void main(String[] args) {
    List<List<Integer>> testCase = List.of(
        List.of(112, 42, 83, 119),
        List.of(56, 125, 56, 49),
        List.of(15, 78, 101, 43),
        List.of(62, 98, 114, 108));

    int val = findMax(testCase);
    System.out.println(val);

  }
}
