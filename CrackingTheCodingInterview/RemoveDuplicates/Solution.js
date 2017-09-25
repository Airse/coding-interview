// Runtime: O(n^2)
function removeDuplicates(s) {
  if (s.length == 0) {
    return s;
  }

  let tail = 0;
  for (let i = 1; i < s.length; i++) {
    let hasDuplicate = false;
    for (let j = 0; j <= tail; j++) {
      if (s[i] === s[j]) {
        hasDuplicate = true;
        break;
      }
    }

    if (!hasDuplicate) {
      tail += 1;
      s[tail] = s[i];
    }
  }

  return s.substring(0, tail + 1);
}

// Test Cases
console.log(removeDuplicates(''));
console.log(removeDuplicates('aa'));
console.log(removeDuplicates('aba'));
console.log(removeDuplicates('abcbac'));
console.log(removeDuplicates('aaaaaaa'));
console.log(removeDuplicates('abcd'));