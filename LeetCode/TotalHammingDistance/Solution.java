class Solution {
  public int totalHammingDistance(int[] nums) {
    int total = 0;

    for (int b = 0; b < 32; b++) {
      int bit = 1 << b;
      int count = 0;
      for (int i = 0; i < nums.length; i++) {
        count += (nums[i] & bit) == 0 ? 0 : 1;
      }
      total += count * (nums.length - count);
    }

    return total;
  }
}
