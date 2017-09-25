process.stdin.resume();
process.stdin.setEncoding('ascii');

var input_stdin = "";
var input_stdin_array = "";
var input_currentline = 0;

process.stdin.on('data', function (data) {
  input_stdin += data;
});

process.stdin.on('end', function () {
  input_stdin_array = input_stdin.split("\n");
  main();
});

function readLine() {
  return input_stdin_array[input_currentline++];
}

/////////////// ignore above this line ////////////////////

// Runtime: O(n + m) where n is number of words in ransom
// and m is number of words in magazine
function main() {
  var m_temp = readLine().split(' ');
  var m = parseInt(m_temp[0]);
  var n = parseInt(m_temp[1]);
  var magazine = readLine().split(' ');
  var ransom = readLine().split(' ');

  wordMap = {};
  magazine.forEach((word) => {
    if (wordMap[word]) {
      wordMap[word] += 1;
    } else {
      wordMap[word] = 1;
    }
  });

  for (let i = 0; i < ransom.length; i++) {
    let word = ransom[i];
    if (wordMap[word]) {
      wordMap[word] -= 1;
    } else {
      console.log('No');
      return;
    }
  }

  console.log('Yes');
}
