package day1;
import java.util.List;

class PlusMinus {

  public static float getRatio(long value, int totalSize) {
    return (float) value / totalSize;
  }

  public static void plusMinus(List<Integer> arr) {
    
        int arrSize = arr.size();

        long positiveValues = arr.stream().filter(num -> num > 0).count();
        long negativeValues = arr.stream().filter(num -> num < 0).count();
        long zeroValues = arrSize - positiveValues - negativeValues;

        float positiveRatios = getRatio(positiveValues, arrSize);
        float negativeRatios = getRatio(negativeValues, arrSize);
        float zeroRatios = getRatio(zeroValues, arrSize);

        System.out.printf("%,.6f%n", positiveRatios);
        System.out.printf("%,.6f%n", negativeRatios);
        System.out.printf("%,.6f", zeroRatios);
  }

  public static void main(String[] args) {
    plusMinus(List.of(1, 1, 0, -1, -1));
  }

}