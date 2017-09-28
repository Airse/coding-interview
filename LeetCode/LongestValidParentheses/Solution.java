class Solution {
  // Runtime: O(n)
  public int longestValidParentheses(String s) {
    int[] lengths = new int[s.length()];

    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        int totalLength = 0;
        if (s.charAt(i - 1) == ')') {
          if (i - lengths[i - 1] - 1 >= 0 && s.charAt(i - lengths[i - 1] - 1) == '(') {
            totalLength += lengths[i - 1] + 2;
          }
        } else {
          totalLength += 2;
        }
        
        if (totalLength > 0 && (i - totalLength) >= 0) {
          totalLength += lengths[i - totalLength];
        }

        lengths[i] = totalLength;
      }
    }

    int max = 0;
    for (int i = 0; i < lengths.length; i++) {
      max = Math.max(lengths[i], max);
    }
    return max;
  }
}