class Solution {
  public int findMin(int[] nums) {
    int index = findMinIndex(nums);
    return nums[index];
  }

  public int findMinIndex(int[] nums) {
    int start = 0;
    int end = nums.length - 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[start] <= nums[end]) {
        return start;
      }

      if (nums[mid] < nums[end]) {
        // search left
        end = mid;
      } else {
        // search right
        start = mid + 1;
      }
    }

    return -1;
  }
}