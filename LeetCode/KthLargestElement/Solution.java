class Solution {
  private static Random random = new Random();

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public int quickSelect(int[] nums, int low, int high, int k) {
    // random partition
    int randomPartition = random.nextInt(high - low + 1) + low;
    swap(nums, randomPartition, low);

    int partition = low;
    int mid = low;
    int current = low + 1;
    while (current <= high) {
      if (nums[current] < nums[partition]) {
        if (current != mid + 1) {
          int temp = nums[current];
          nums[current] = nums[mid + 1];
          nums[mid + 1] = temp;
        }
        mid++;
      }
      current++;
    }

    swap(nums, partition, mid);

    int position = mid - low + 1;

    if (position == k) {
      return nums[mid];
    } else if (position > k) { // look left
      return quickSelect(nums, low, mid - 1, k);
    }
    // look right
    return quickSelect(nums, mid + 1, high, k - position);
  }

  public int findKthLargest(int[] nums, int k) {
    return quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
  }
}