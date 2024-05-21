package algoMonster.twoPointer;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

  public static int longestSubstringWithoutRepeatingCharacters(String s) {

    int longestSubstring = 0;

    for (int pointerOne = 0; pointerOne < s.length(); pointerOne++) {
      Set<Character> substring = new HashSet<>();

      for (int pointerTwo = pointerOne; pointerTwo < s.length(); pointerTwo++) {
        if (!substring.contains(s.charAt(pointerTwo))) {
          substring.add(s.charAt(pointerTwo));
        } else {
          if (substring.size() > longestSubstring) {
            longestSubstring = substring.size();
          }
          substring.clear();
          break;
        }
      }
      if (substring.size() > longestSubstring) {
        longestSubstring = substring.size();
      }
      substring.clear();
    }

    return longestSubstring;
  }

  public static void main(String[] args) {
    int result = longestSubstringWithoutRepeatingCharacters("abcdbea");
    System.out.println("value is : " + result);
  }
}
