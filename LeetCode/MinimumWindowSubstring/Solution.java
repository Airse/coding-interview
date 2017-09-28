class Solution {
  public String minWindow(String s, String t) {
    int[] counts = new int[100];
    boolean[] hasChar = new boolean[100];
    for (int i = 0; i < t.length(); i++) {
      counts[t.charAt(i) - 'A']++;
      hasChar[t.charAt(i) - 'A'] = true;
    }

    int left = 0;
    int right = 0;
    int count = 0;
    int leftMin = -1;
    int rightMin = s.length();
    char[] a = s.toCharArray();
    int[] windowCounts = new int[100];

    while (right < a.length) {
      int rightChar = a[right] - 'A';
      if (hasChar[rightChar]) {
        windowCounts[rightChar]++;
        count += windowCounts[rightChar] <= counts[rightChar] ? 1 : 0;
      }

      if (count == t.length()) {
        while (count == t.length()) {
          int leftChar = a[left] - 'A';
          if (hasChar[leftChar]) {
            windowCounts[leftChar]--;
            count -= windowCounts[leftChar] < counts[leftChar] ? 1 : 0;
          }
          left++;
        }
        left -= 1;
        if (right - left < rightMin - leftMin) {
          leftMin = left;
          rightMin = right;
        }
        left++;
      }

      right++;
    }

    if (leftMin == -1) {
      return "";
    }

    StringBuilder result = new StringBuilder();
    for (int i = leftMin; i <= rightMin; i++) {
      result.append(a[i]);
    }

    return result.toString();
  }
}