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

  public int findKthSmallest(int[] nums, int k) {
    return quickSelect(nums, 0, nums.length - 1, k);
  }

  public void wiggleSort(int[] nums) {
    int middle = findKthSmallest(nums, (nums.length + 1) / 2);
    int[] numsWiggle = new int[nums.length];
    int odd = nums.length % 2 == 0 ? nums.length - 2 : nums.length - 1;
    int even = 1;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < middle) {
        numsWiggle[odd] = nums[i];
        odd -= 2;
      }
      if (nums[i] > middle) {
        numsWiggle[even] = nums[i];
        even += 2;
      }
    }

    // fill in the middles
    while (odd >= 0) {
      numsWiggle[odd] = middle;
      odd -= 2;
    }
    while (even < nums.length) {
      numsWiggle[even] = middle;
      even += 2;
    }

    for (int i = 0; i < nums.length; i++) {
      nums[i] = numsWiggle[i];
    }
  }
}