class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<List<String>>();
    Map<String, Integer> map = new HashMap<String, Integer>();

    for (String s : strs) {
      char[] a = s.toCharArray();
      Arrays.sort(a);
      String sortedS = new String(a);

      if (map.get(sortedS) == null) {
        List<String> newAnagramGroup = new ArrayList<String>();
        newAnagramGroup.add(s);
        result.add(newAnagramGroup);

        map.put(sortedS, result.size() - 1);
      } else {
        int groupIndex = map.get(sortedS);
        result.get(groupIndex).add(s);
      }
    }

    return result;
  }
}
