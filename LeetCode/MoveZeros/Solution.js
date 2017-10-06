var swap = function(nums, i, j) {
  let temp = nums[i];
  nums[i] = nums[j];
  nums[j] = temp;
};

/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function (nums) {
  let firstZero = -1;
  for (let i = 0; i < nums.length; i += 1) {
    if (nums[i] === 0 && firstZero === -1) {
      firstZero = i;
    } else if (nums[i] !== 0 && firstZero !== -1) {
      swap(nums, i, firstZero);
      if (nums[firstZero + 1] === 0) {
        firstZero += 1;
      } else {
        firstZero = -1;
      }
    }
  }
};
