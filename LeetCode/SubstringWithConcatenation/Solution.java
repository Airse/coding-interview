class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    int wordLength = words[0].length();
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for (String word : words) {
      if (map.get(word) != null) {
        map.put(word, map.get(word) + 1);
      } else {
        map.put(word, 1);
      }
    }

    int left = 0;
    List<Integer> result = new ArrayList<Integer>();

    while (left < s.length() - (wordLength * words.length - 1)) {
      HashMap<String, Integer> testMap = new HashMap<String, Integer>();
      int count = 0;
      for (int i = 0; i < words.length; i++) {
        String word = s.substring(left + (i * wordLength), left + ((i + 1) * wordLength));

        if (map.get(word) != null) {
          testMap.put(word, testMap.get(word) == null ? 1 : testMap.get(word) + 1);
          if (testMap.get(word) <= map.get(word)) {
            count++;
          } else {
            break;
          }
        } else {
          break;
        }
      }

      if (count == words.length) {
        result.add(left);
      }

      left++;
    }

    return result;
  }
}