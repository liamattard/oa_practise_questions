import java.util.Arrays;

public class SuitableLocation {

  public static int suitableWarehouses(int[] points, int d) {

    Arrays.sort(points);

    int minimumWarehouse = points[points.length / 2] - (d / 2);
    int maximumWarehouse = points[points.length / 2] + (d / 2);

    int totalDistance = 0;
    int numberOfPoints = 0;

    for (int i = minimumWarehouse; i < maximumWarehouse + 1; i++) {
      for (int point : points) {
        totalDistance += Math.abs(2 * (i - point));
      }

      if (totalDistance <= d) {
        numberOfPoints++;
      }
      totalDistance = 0;
    }

    return numberOfPoints;
  }

  public static void main(String[] args) {
    int[] points1 = { -2, 1, 0 };
    int d1 = 8;
    System.out.println(suitableWarehouses(points1, d1));

    int[] points2 = { 2, 0, 3, -4 };
    int d2 = 22;
    System.out.println(suitableWarehouses(points2, d2));

    int[] points3 = { -3, 2, 2 };
    int d3 = 20;
    System.out.println(suitableWarehouses(points3, d3));
  }
}
