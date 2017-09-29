class Solution {
  private int[][] memo;
  private char[] s;
  private char[] t;

  private int minDistance(int si, int ti) {
    if (si == s.length) {
      return t.length - ti; // delete all leftover (or insert; same thing)
    }
    if (ti == t.length) {
      return s.length - si; // delete all leftover (or insert; same thing)
    }

    if (memo[si][ti] != -1) {
      return memo[si][ti];
    }

    // try update
    memo[si][ti] = (s[si] == t[ti] ? 0 : 1) + minDistance(si + 1, ti + 1);
    // try delete
    memo[si][ti] = Math.min(memo[si][ti], minDistance(si + 1, ti) + 1);
    // try add
    memo[si][ti] = Math.min(memo[si][ti], minDistance(si, ti + 1) + 1);

    return memo[si][ti];
  }

  public int minDistance(String word1, String word2) {
    s = word1.toCharArray();
    t = word2.toCharArray();
    memo = new int[word1.length()][word2.length()];
    for (int i = 0; i < word1.length(); i++) {
      for (int j = 0; j < word2.length(); j++) {
        memo[i][j] = -1;
      }
    }

    return minDistance(0, 0);
  }
}