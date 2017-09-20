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

function isPrime(n) {
  if (n <= 1) {
    return false;
  }
  if (n == 2) {
    return true;
  }
  var sqrtN = Math.sqrt(n) + 1;
  for (let i = 2; i <= sqrtN; i += 1) {
    if (n % i == 0) {
      return false;
    }
  }

  return true;
}

function main() {
  var p = parseInt(readLine());
  for (var a0 = 0; a0 < p; a0++) {
    var n = parseInt(readLine());
    console.log(isPrime(n) ? 'Prime' : 'Not prime');
  }
}
