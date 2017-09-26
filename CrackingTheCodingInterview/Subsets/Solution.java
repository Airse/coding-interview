class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<List<Integer>>();
    subsets.add(new ArrayList()); // add the empty set

    subsets(subsets, nums, 0);

    return subsets;
  }

  public void subsets(List<List<Integer>> subsets, int[] nums, int start) {
    if (start >= nums.length) {
      return;
    }

    List<List<Integer>> newSubSets = new ArrayList<List<Integer>>();

    for (List<Integer> subset : subsets) {
      List<Integer> newSubset = new ArrayList<Integer>(subset);
      newSubset.add(nums[start]);

      newSubSets.add(newSubset);
    }
    subsets.addAll(newSubSets);

    subsets(subsets, nums, start + 1);
  }
}