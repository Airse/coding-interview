var twoSum = function (nums, target, start) {
  let i = start;
  let j = nums.length - 1;
  let result = [];

  while (i < j) {
    let sum = nums[i] + nums[j];

    if (sum === target) {
      result.push([nums[i], nums[j]]);
      while (i + 1 < j && nums[i] === nums[i + 1]) {
        i += 1;
      }
      while (j - 1 > i && nums[j] === nums[j - 1]) {
        j -= 1;
      }
      i += 1;
      j -= 1;
    } else if (sum < target) {
      i += 1;
    } else {
      j -= 1;
    }
  }

  return result;
};

var threeSum = function (nums, target, start) {
  let result = [];

  for (let i = start; i < nums.length - 2; i += 1) {
    if (i > start && nums[i - 1] === nums[i]) {
      continue;
    }
    let pairs = twoSum(nums, target - nums[i], i + 1);
    pairs.forEach((pair) => {
      result.push([nums[i]].concat(pair));
    })
  }

  return result;
};

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function (nums, target) {
  nums.sort((a, b) => a - b);

  let result = [];
  for (let i = 0; i < nums.length - 3; i += 1) {
    if (i > 0 && nums[i - 1] === nums[i]) {
      continue;
    }
    let triplets = threeSum(nums, target - nums[i], i + 1);
    triplets.forEach((triplet) => {
      result.push([nums[i]].concat(triplet));
    })
  }

  return result;
};