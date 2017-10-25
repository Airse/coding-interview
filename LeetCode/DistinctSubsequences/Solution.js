/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
var numDistinct = function (s, t) {
  if (t.length == 0) {
    return;
  }
  if (s.length == 0) {
    return 0;
  }

  let memo = [];
  for (let i = 0; i < t.length; i++) {
    let row = [];
    for (let j = 0; j < s.length; j++) {
      row.push(0);
    }
    memo.push(row);
  }

  for (let i = 0; i < t.length; i++) {
    for (let j = 0; j < s.length; j++) {
      if (s[j] === t[i]) {
        if (i - 1 < 0) {
          memo[i][j] = 1 + (j - 1 < 0 ? 0 : memo[i][j - 1]);
        } else if (i - 1 >= 0 && j - 1 >= 0) {
          memo[i][j] = memo[i - 1][j - 1] + memo[i][j - 1];
        }
      } else if (j - 1 >= 0) {
        memo[i][j] = memo[i][j - 1];
      }
    }
  }

  return memo[t.length - 1][s.length - 1];
};
