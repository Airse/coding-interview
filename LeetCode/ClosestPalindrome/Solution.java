class Solution {
  private String mirrorNumber(boolean doDuplicateMiddle, long number) {
    StringBuilder sb = new StringBuilder(number + "");
    String result = number + "";

    if (doDuplicateMiddle) {
      result += sb.reverse().toString();
    } else {
      result += sb.reverse().deleteCharAt(0).toString();
    }

    return result;
  }

  private String generateNineDigits(int length) {
    StringBuilder sb = new StringBuilder();
    while (length-- > 0) {
      sb.append('9');
    }
    return sb.toString();
  }

  public String nearestPalindromic(String n) {
    if (n.length() == 0) {
      return n;
    }

    boolean isLengthEven = n.length() % 2 == 0;
    int half = (n.length() / 2) + (isLengthEven ? -1 : 0);

    String nHalf = n.substring(0, half + 1);
    long nHalfVal = Long.parseLong(nHalf);

    ArrayList<String> possiblePalindromes = new ArrayList<String>();
    // case to generate 9999
    if (n.length() > 1) {
      possiblePalindromes.add(generateNineDigits(n.length() - 1));
    }
    // case to generate -1 then flip
    if (nHalfVal > 0) {
      possiblePalindromes.add(mirrorNumber(isLengthEven, nHalfVal - 1));
    }

    // case to generate normal palindrome
    possiblePalindromes.add(mirrorNumber(isLengthEven, nHalfVal));

    // case to generate +1 then flip
    // must handle the special case of 9 + 1
    String palindromeMirrorPlusOne = mirrorNumber(isLengthEven, nHalfVal + 1);
    if (palindromeMirrorPlusOne.length() > n.length()) {
      if (isLengthEven) {
        palindromeMirrorPlusOne = mirrorNumber(!isLengthEven, nHalfVal + 1);
      } else {
        palindromeMirrorPlusOne = mirrorNumber(!isLengthEven, (nHalfVal / 10) + 1);
      }
    }
    possiblePalindromes.add(palindromeMirrorPlusOne);

    // find the closest palindromes out of all possible closest palindromes
    long nVal = Long.parseLong(n);
    String closestPalindrome = "";
    long minDifference = Long.MAX_VALUE;

    for (String palindrome : possiblePalindromes) {
      long pVal = Long.parseLong(palindrome);
      long difference = Math.abs(pVal - nVal);

      if (difference > 0 && difference < minDifference) {
        closestPalindrome = palindrome;
        minDifference = difference;
      }
    }

    return closestPalindrome;
  }
}