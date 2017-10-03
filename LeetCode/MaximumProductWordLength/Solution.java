class Solution {
  public int maxProduct(String[] words) {
    int[] wordsInt = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      int wordInt = 0;
      for (int c = 0; c < word.length(); c++) {
        int letter = word.charAt(c) - 'a';
        int mask = 1 << letter;
        wordInt = wordInt | mask;
      }

      wordsInt[i] = wordInt;
    }

    int maxProduct = 0;

    for (int i = 0; i < wordsInt.length - 1; i++) {
      for (int j = i + 1; j < wordsInt.length; j++) {
        if ((wordsInt[i] & wordsInt[j]) == 0) {
          int product = words[i].length() * words[j].length();
          maxProduct = Math.max(maxProduct, product);
        }
      }
    }

    return maxProduct;
  }
}