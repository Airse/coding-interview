import java.io.*;
import java.util.*;

// Runtime: O(3^n)
public class Solution {
  public static String solveOperators(long currentResult, int[] list, int i) {
    if (i >= list.length) {
      return null;
    }

    if (i == list.length - 1) {
      return (currentResult % 101 == 0) ? ("" + list[i]) : null;
    }

    if (i == 0) {
      currentResult = list[i];
    }

    long prevResult = currentResult;

    // if the current result is already divisible by 101 then we don't have to try plus or minus
    if (currentResult % 101 != 0) {
      // try add
      currentResult = prevResult + list[i + 1];
      String addResult = solveOperators(currentResult, list, i + 1);
      if (addResult != null) {
        return list[i] + "+" + addResult;
      }

      // try minus
      currentResult = prevResult - list[i + 1];
      String minusResult = solveOperators(currentResult, list, i + 1);
      if (minusResult != null) {
        return list[i] + "-" + minusResult;
      }

    }

    // try multiply
    // modulo the current result to prevent overflow
    currentResult = (prevResult * list[i + 1] % 101);
    String multiplyResult = solveOperators(currentResult % 101, list, i + 1);
    if (multiplyResult != null) {
      return list[i] + "*" + multiplyResult;
    }

    return null;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] list = new int[n];

    for (int i = 0; i < n; i++) {
      list[i] = sc.nextInt();
    }

    System.out.println(solveOperators(0, list, 0));

    sc.close();
  }
}