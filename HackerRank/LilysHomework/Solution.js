// counts the number of swaps needed to transform a to b
function countSwaps(a, b) {
  const map = {};
  a.forEach((e, i) => {
    map[e] = i;
  });

  const transform = a.slice();
  let numSwaps = 0;

  for (let i = 0; i < transform.length; i++) {
    if (transform[i] !== b[i]) {
      const originalIndex = map[b[i]];
      
      transform[originalIndex] = transform[i];
      transform[i] = b[i];

      map[transform[originalIndex]] = originalIndex;
      map[transform[i]] = i;

      numSwaps += 1;
    }
  }

  return numSwaps;
}

function numSwaps(a) {
  const sorted = a.slice();
  sorted.sort((i, j) => i - j);
  const sortedReverse = sorted.slice().reverse();

  return Math.min(countSwaps(a, sorted), countSwaps(a, sortedReverse));
}

function processData(input) {
  input = input.split('\n');
  let a = input[1].split(' ').map(e => (parseInt(e)));

  console.log(numSwaps(a));
} 

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
  _input += input;
});

process.stdin.on("end", function () {
 processData(_input);
});
