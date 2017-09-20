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

function sherlockAndAnagrams(s) {
  // generate all substrings
  var substrings = [];
  for (let i = 0; i < s.length; i++) {
    for (let j = i + 1; j <= s.length; j++) {
      substrings.push(s.substring(i, j).split('').sort().join(''));
    }
  }

  substrings.sort();

  let i = 0;
  let pairs = 0;
  
  for (let i = 0; i < substrings.length; i++) {
    for (let j = i + 1; j < substrings.length; j++) {
      if (substrings[i] === substrings[j]) {
        pairs++;
      } else {
        break;
      }
    }
  }

  return pairs;
}

function main() {
  var q = parseInt(readLine());
  for (var a0 = 0; a0 < q; a0++) {
    var s = readLine();
    var result = sherlockAndAnagrams(s);
    process.stdout.write("" + result + "\n");
  }
}
