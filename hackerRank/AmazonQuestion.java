import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AmazonQuestion {

  public static int countGroups(List<String> related) {

    Map<Integer, Integer> belongsToGroup = new HashMap<>();
    Map<Integer, String> relations = new HashMap<>();

    for (int i = 0; i < related.size(); i++) {
      if (Integer.parseInt(related.get(i)) == 1) {
        relations.put(i, "" + i);
        continue;
      }

      for (int j = 0; j < related.get(i).length(); j++) {
        if (i == j) {
          continue;
        }

        if (related.get(i).charAt(j) == '1') {
          if (belongsToGroup.containsKey(i)) {
            int parentGroup = belongsToGroup.get(i);
            relations.put(parentGroup, relations.get(parentGroup) + j);
            belongsToGroup.put(j, parentGroup);
          } else {
            relations.put(i, "" + i + j);
            belongsToGroup.put(j, i);
          }
        }
      }
    }

    return relations.size();
  }

  public static void traverseGroup(Set<Integer> visited, Integer currentMember, List<String> related) {
    visited.add(currentMember);

    for (int i = 0; i < related.size(); i++) {
      char currentChar = related.get(currentMember).charAt(i);
      if (currentChar == '1' && !visited.contains(i)) {
        traverseGroup(visited, i, related);
      }

    }
  }

  public static int countGroupsTwo(List<String> related) {

    Set<Integer> visited = new HashSet<>();
    int groups = 0;

    for (int i = 0; i < related.size(); i++) {
      if (!visited.contains(i)) {
        traverseGroup(visited, i, related);
        groups++;
      }

    }

    return groups;
  }

  public static void main(String[] args) {

    List<String> related = List.of("1100", "1110", "0110", "0001");
    System.out.println("Number of groups: " + countGroupsTwo(related));

  }
}
