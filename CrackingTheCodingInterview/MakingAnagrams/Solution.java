import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
  private static final int NUM_LETTERS = 26;

  public static int numberNeeded(String first, String second) {
    int[] firstLetters = new int[NUM_LETTERS];
    int[] secondLetters = new int[NUM_LETTERS];

    for (int i = 0; i < first.length(); i++) {
      firstLetters[first.charAt(i) - 'a']++;
    }

    for (int i = 0; i < second.length(); i++) {
      secondLetters[second.charAt(i) - 'a']++;
    }

    int numberNeeded = 0;
    for (int i = 0; i < NUM_LETTERS; i++) {
      numberNeeded += Math.abs(firstLetters[i] - secondLetters[i]);
    }
    return numberNeeded;
  }
  
  public static void main(String[] args) {
      Scanner in = new Scanner(System.in);

      String a = in.next();
      String b = in.next();
      System.out.println(numberNeeded(a, b));

      in.close();
    }
}
