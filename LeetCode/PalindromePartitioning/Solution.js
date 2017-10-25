var isPalindrome = function(s, start, end) {
  if (start > end) {
    return true;
  }
  if (s[start] === s[end]) {
    return isPalindrome(s, start + 1, end - 1);
  }

  return false;
};

var findPalindromes = function (s, start, end) {
  if (start > end) {
    return [];
  }

  let result = [];

  for (let i = start; i <= end; i++) {
    if (isPalindrome(s, start, i)) {
      let palindrome = s.substring(start, i + 1);
      let subPartitions = findPalindromes(s, i + 1, end);

      if (subPartitions.length === 0) {
        result.push([palindrome]);
      } else {
        subPartitions.forEach((subPartition) => {
          result.push([palindrome].concat(subPartition));
        });
      }
    }
  }

  return result;
};

/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function (s) {
  return findPalindromes(s, 0, s.length - 1);
};
