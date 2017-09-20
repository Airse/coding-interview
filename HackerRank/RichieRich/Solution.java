import java.util.*;

public class Solution {
  public static String richieRich(String s, int n, int k) {
    boolean[] changed = new boolean[n];
    char[] palindrome = s.toCharArray();

    // make into palindrome
    int halfMark = (n - 1) / 2;
    for (int i = 0; i <= halfMark; i++) {
      int j = n - 1 - i;
      if (i == j) {
        break;
      }
      if (palindrome[i] < palindrome[j]) {
        k--;
        palindrome[i] = palindrome[j];
        changed[i] = true;
      } else if (palindrome[i] > palindrome[j]) {
        k--;
        palindrome[j] = palindrome[i];
        changed[j] = true;
      }
      if (k < 0) {
        return "-1";
      }
    }

    // maximize palindrome
    for (int i = 0; i <= halfMark; i++) {
      int j = n - 1 - i;

      if (palindrome[i] < '9') {
        int toChange = 0;

        toChange += (changed[i]) ? 0 : 1;
        if (i != j) {
          toChange += (changed[j]) ? 0 : 1;
        }

        if (toChange <= k) {
          k -= toChange;
          palindrome[i] = '9';
          palindrome[j] = '9';
        }
      }
      if (k == 0) {
        break;
      }
    }

    return new String(palindrome);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    String s = in.next();
    String result = richieRich(s, n, k);
    System.out.println(result);
  }
}
