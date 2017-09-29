class Solution {
  private int[] memo;

  private int charactersToNumber(String s, int start, int end) {
    String number = "";
    for (int i = start; i <= end; i++) {
      number += s.charAt(i);
    }
    return Integer.parseInt(number);
  }

  public int numDecodings(String s, int start) {
    if (start == s.length()) {
      return 1;
    }
    if (memo[start] != -1) {
      return memo[start];
    }

    memo[start] = 0;

    // try one character
    int oneCharacter = charactersToNumber(s, start, start);
    if (oneCharacter >= 1) {
      memo[start] += numDecodings(s, start + 1);
    }

    // try two characters
    if (start < s.length() - 1) {
      int twoCharacters = charactersToNumber(s, start, start + 1);
      if (twoCharacters >= 10 && twoCharacters <= 26) {
        memo[start] += numDecodings(s, start + 2);
      }
    }

    return memo[start];
  }

  public int numDecodings(String s) {
    if (s.length() == 0) {
      return 0;
    }
    memo = new int[s.length()];
    for (int i = 0; i < memo.length; i++) {
      memo[i] = -1;
    }
    return numDecodings(s, 0);
  }
}
