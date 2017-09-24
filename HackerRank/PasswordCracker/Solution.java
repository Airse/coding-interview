import java.io.*;
import java.util.*;

public class Solution {
  private static String[] memo;

  public static String solvePasswords(String[] passwords, String loginAttempt, int start) {
    if (start >= loginAttempt.length()) {
      return "";
    }

    if (memo[start] != null) {
      return memo[start];
    }

    for (String password : passwords) {
      if (loginAttempt.startsWith(password, start)) {
        String rest = solvePasswords(passwords, loginAttempt, start + password.length());
        if (!"-".equals(rest)) {
          memo[start] = password + " " + rest;
          return memo[start];
        }
      }
    }

    memo[start] = "-";

    return memo[start];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numTestCases = sc.nextInt();

    for (int t = 0; t < numTestCases; t++) {
      int n = sc.nextInt();
      String[] passwords = new String[n];
      for (int i = 0; i < n; i++) {
        passwords[i] = sc.next();
      }

      String loginAttempt = sc.next();
      memo = new String[loginAttempt.length()];

      String solvedPasswords = solvePasswords(passwords, loginAttempt, 0);
      System.out.println(solvedPasswords.equals("-") ? "WRONG PASSWORD" : solvedPasswords);
    }

    sc.close();
  }
}