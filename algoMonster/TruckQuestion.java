package algoMonster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TruckQuestion {

  public static Map<Integer, Integer> getListFormat(int[][] boxTypes) {
    Map<Integer, Integer> boxTypesMap = new HashMap<>();
    for (int[] box : boxTypes) {
      if (boxTypesMap.containsKey(box[1])) {
        boxTypesMap.put(box[1], boxTypesMap.get(box[1]) + box[0]);
      } else {
        boxTypesMap.put(box[1], box[0]);

      }
    }

    return boxTypesMap;
  }

  public static int maximumUnits(int[][] boxTypes, int truckSize) {
    int currentBoxes = 0;
    int currentUnits = 0;

    Map<Integer, Integer> boxTypesMap = getListFormat(boxTypes);
    List<Integer> sortedUnits = boxTypesMap.keySet().stream().sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());

    // convertToWhile
    for (int i = 0; i < sortedUnits.size(); i++) {
      int currentUnit = sortedUnits.get(i);

      while (boxTypesMap.get(currentUnit) > 0) {
        if (currentBoxes < truckSize) {
          boxTypesMap.put(currentUnit, boxTypesMap.get(currentUnit) - 1);
          currentUnits += currentUnit;
          currentBoxes++;
        } else {
          break;
        }
      }

    }

    return currentUnits;
  }

  public static void main(String[] args) {
    maximumUnits(new int[][] { new int[] { 1, 3 }, new int[] { 2, 2 }, new int[] { 3, 1 } }, 2);
  }
}
