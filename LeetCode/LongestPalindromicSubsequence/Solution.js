var memo = [];

var longestPalindromeSubseqRec = function (s, start, end) {
  if (start > end) {
    return 0;
  }
  if (start === end) {
    memo[start][end] = 1;
  }
  if (memo[start][end] !== -1) {
    return memo[start][end];
  }

  var max = 1;
  if (s[start] === s[end]) {
    max = Math.max(max, 2 + longestPalindromeSubseqRec(s, start + 1, end - 1));
  }
  max = Math.max(max, longestPalindromeSubseqRec(s, start + 1, end));
  max = Math.max(max, longestPalindromeSubseqRec(s, start, end - 1));

  memo[start][end] = max;

  return memo[start][end];
};

var longestPalindromeSubseq = function (s) {
  memo = [];
  for (let i = 0; i < s.length; i++) {
    memo.push(Array(s.length).fill(-1));
  }
  
  return longestPalindromeSubseqRec(s, 0, s.length - 1);
};