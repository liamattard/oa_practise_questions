package algoMonster.twoPointer;

public class musicDivisible {

  public static int numPairsDivisibleBy60(int[] time) {
    int foundSolution = 0;
    for (int i = 0; i < time.length - 1; i++) {
      for (int j = i + 1; j < time.length; j++) {
        if ((time[i] + time[j]) % 60 == 0) {
          foundSolution++;
        }
      }
    }
    return foundSolution;
  }

  public static void main(String[] args) {
    int[] item = new int[] { 30, 20, 150, 100, 40 };
    numPairsDivisibleBy60(item);
  }

}
