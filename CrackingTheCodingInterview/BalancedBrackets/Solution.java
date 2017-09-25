import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Runtime: O(n)
public class Solution {
  private static final char[] OPEN_BRACKETS = { '(', '[', '{' };
  private static final char[] CLOSE_BRACKETS = { ')', ']', '}' };

  private static boolean isOpenBracket(char bracket) {
    for (char b : OPEN_BRACKETS) {
      if (b == bracket) {
        return true;
      }
    }
    return false;
  }

  private static boolean isMatchingBracket(char openBracket, char closeBracket) {
    int openBracketIndex = -1;
    for (int i = 0; i < OPEN_BRACKETS.length; i++) {
      if (OPEN_BRACKETS[i] == openBracket) {
        openBracketIndex = i;
      }
    }

    if (openBracketIndex < 0 || openBracketIndex >= OPEN_BRACKETS.length) {
      return false;
    }

    return CLOSE_BRACKETS[openBracketIndex] ==  closeBracket;
  }

  public static boolean isBalanced(String expression) {
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < expression.length(); i++) {
      char bracket = expression.charAt(i);
      if (isOpenBracket(bracket)) {
        stack.push(bracket);
        continue;
      }

      if (stack.isEmpty()) {
        return false;
      }

      char openBracket = stack.pop();
      if (!isMatchingBracket(openBracket, bracket)) {
        return false;
      }
    }
    
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      String expression = in.next();
      System.out.println((isBalanced(expression)) ? "YES" : "NO" );
    }

    in.close();
  }
}
