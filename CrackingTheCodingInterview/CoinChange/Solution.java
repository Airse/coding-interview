import java.util.*;

// Runtime: O(c * n)
public class Solution {
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int m = in.nextInt();
      int coins[] = new int[m];
      for (int coins_i = 0; coins_i < m; coins_i++) {
        coins[coins_i] = in.nextInt();
      }

      Arrays.sort(coins);

      long[] memo = new long[n + 1];
      memo[0] = 1;
      for (int c = 0; c < coins.length; c++) {
        for (int i = coins[c]; i < memo.length; i++) {
          memo[i] += memo[i - coins[c]];
        }
      }

      System.out.println(memo[n]);

      in.close();
  }
}
