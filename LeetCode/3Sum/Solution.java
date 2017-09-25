class Solution {
  // Runtime: O(n)
  public List<List<Integer>> twoSum(int[] nums, int start, int sum) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    int i = start;
    int j = nums.length - 1;

    while (i < j) {
      // to prevent duplicates
      if (i > start && nums[i - 1] == nums[i]) {
        i++;
        continue;
      }
      if (nums[i] + nums[j] == sum) {
        ArrayList<Integer> pair = new ArrayList<Integer>();
        pair.add(nums[i]);
        pair.add(nums[j]);
        result.add(pair);
        i++;
        j--;
      } else if (nums[i] + nums[j] < sum) {
        i++;
      } else {
        j--;
      }
    }

    return result;
  }

  // Runtime: O(n^2)
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }

      List<List<Integer>> pairs = twoSum(nums, i + 1, 0 - nums[i]);
      for (List<Integer> pair : pairs) {
        pair.add(nums[i]);
        result.add(pair);
      }
    }

    return result;
  }
}