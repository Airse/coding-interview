class Solution {
  private boolean checkValidString(char[] s, int start, int numOpen) {
    if (start == s.length) {
      return numOpen == 0;
    }
    if (s[start] == '(') {
      return checkValidString(s, start + 1, numOpen + 1);
    } else if (s[start] == ')') {
      if (numOpen == 0) {
        return false;
      }
      return checkValidString(s, start + 1, numOpen - 1);
    }

    // case of *
    boolean isValid = false;

    // * is )
    if (numOpen > 0) {
      isValid = checkValidString(s, start + 1, numOpen - 1);
    }

    // * is empty string
    if (!isValid) {
      isValid = checkValidString(s, start + 1, numOpen);
    }

    // * is (
    if (!isValid) {
      isValid = checkValidString(s, start + 1, numOpen + 1);
    }

    return isValid;
  }

  public boolean checkValidString(String s) {
    char[] a = s.toCharArray();
    return checkValidString(a, 0, 0);
  }
}