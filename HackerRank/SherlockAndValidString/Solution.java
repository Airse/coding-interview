import java.util.*;
import java.math.*;

public class Solution {
  static String isValid(String string) {
    if (string.length() <= 2) {
      return "YES";
    }
    int[] letters = new int[26];
    char[] s = string.toCharArray();

    for (char c : s) {
      letters[c - 'a']++;
    }

    int freq1 = 0;
    int freq1Count = 0;
    int freq2 = 0;
    int freq2Count = 0;
    for (int i = 0; i < letters.length; i++) {
      if (letters[i] == 0) {
        continue;
      }
      if (freq1 == 0) {
        freq1 = letters[i];
        freq1Count = 1;
      } else if (letters[i] == freq1) {
        freq1Count++;
      } else if (freq2 == 0) {
        freq2 = letters[i];
        freq2Count = 1;
      } else if (letters[i] == freq2) {
        freq2Count++;
      } else {
        return "NO";
      }
    }

    if (freq2 == 0) {
      return "YES";
    }
    if (freq1Count == 1) {
      return (freq1 == 1 || freq1 - freq2 == 1) ? "YES" : "NO";
    }
    if (freq2Count == 1) {
      return (freq2 == 1 || freq2 - freq1 == 1) ? "YES" : "NO";
    }

    return "NO";
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    String result = isValid(s);
    System.out.println(result);

    in.close();
  }
}
