class Solution {
  public int search(int[] nums, int target) {
    if (nums.length == 0) {
      return -1;
    }

    int minIndex = findMinIndex(nums);

    // copy nums to original sorted form
    int[] originalNums = new int[nums.length];
    int j = 0;
    for (int i = minIndex; i < nums.length; i++) {
      originalNums[j] = nums[i];
      j++;
    }
    for (int i = 0; i < minIndex; i++) {
      originalNums[j] = nums[i];
      j++;
    }

    // binary search originalNums
    int start = 0;
    int end = originalNums.length - 1;
    int n = originalNums.length;

    while (start <= end) {
      int mid = (start + end) / 2;

      if (originalNums[mid] == target) {
        return (mid + minIndex) % n;
      }
      if (originalNums[mid] > target) {
        // search left
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return -1;
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

    return -1; // code shouldn't reach here
  }
}