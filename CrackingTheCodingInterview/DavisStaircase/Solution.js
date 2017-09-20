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

function main() {
  var s = parseInt(readLine());
  var memo = [];

  for(var a0 = 0; a0 < s; a0++){
    var n = parseInt(readLine());
    console.log(numWays(n));
  }

  function numWays(n) {
    if (n < 0) {
      return 0;
    }
    if (n <= 1) {
      return 1;
    }

    if (!memo[n]) {
      memo[n] = numWays(n - 1) + numWays(n - 2) + numWays(n - 3);
    }
    return memo[n];
  }
}
