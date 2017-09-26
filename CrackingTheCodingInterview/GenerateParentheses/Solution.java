class Solution {
  public List<String> generateParenthesis(int n) {
    return generateParenthesis(0, n, n);
  }

  public List<String> generateParenthesis(int open, int toOpen, int toClose) {
    List<String> result = new ArrayList<String>();
    if (toOpen == 0 && toClose == 0) {
      result.add("");
      return result;
    }

    // try to open
    if (toOpen > 0) {
      List<String> subResult = generateParenthesis(open + 1, toOpen - 1, toClose);
      for (String sub : subResult) {
        result.add("(" + sub);
      }
    }

    // try to close
    if (open > 0 && toClose > 0) {
      List<String> subResult = generateParenthesis(open - 1, toOpen, toClose - 1);
      for (String sub : subResult) {
        result.add(")" + sub);
      }
    }

    return result;
  }
}