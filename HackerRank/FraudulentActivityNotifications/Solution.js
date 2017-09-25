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

// Runtime: O(n) where n is the length of window
function getMedian(window, d) {
  let isOdd = d % 2 === 1;
  let middle = d / 2;
  let count = 0;

  for (let i = 0; i < window.length; i++) {
    count += window[i];
    if (count > middle) {
      return i;
    }
    if (isOdd && count >= middle) {
      return i;
    }
    if (!isOdd && count >= middle) {
      // get next number
      for (let j = i + 1; j < window.length; j++) {
        if (window[j] > 0) {
          return (i + j) / 2;
        }
      }
    }
  }

  console.error('Something went wrong');
}

// Runtime: O(n * m)
// where n is the length of expenditure
// where m is the range of possible expenditures (in this case 0-200)
function activityNotifications(expenditure, d) {
  let window = [];
  for (let i = 0; i <= 200; i++) {
    window.push(0);
  }
  for (let i = 0; i < d; i++) {
    window[expenditure[i]]++;
  }

  let numNotifications = 0;
  for (let i = d; i < expenditure.length; i++) {
    let median = getMedian(window, d);
    if (expenditure[i] >= 2 * median) {
      numNotifications += 1;
    }

    // shift the window
    window[expenditure[i - d]]--;
    window[expenditure[i]]++;
  }

  return numNotifications;
}

function main() {
  var n_temp = readLine().split(' ');
  var n = parseInt(n_temp[0]);
  var d = parseInt(n_temp[1]);
  expenditure = readLine().split(' ');
  expenditure = expenditure.map(Number);
  var result = activityNotifications(expenditure, d);
  process.stdout.write("" + result + "\n");
}
