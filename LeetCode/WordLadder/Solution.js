var isTransformation = function(s, t) {
  var numChanged = 0;
  for (var i = 0; i < s.length; i++) {
    if (s[i] != t[i])
      numChanged += 1;
  }
  return numChanged === 1;
};

var shortestPath = function(adjList, start, end) {
  let queue = [ { i: start,  d: 1 } ];
  let visited = [];
  visited[start] = true;

  while (queue.length > 0) {
    let current = queue.shift();
    
    if (current.i === end) {
      return current.d;
    }

    adjList[current.i].forEach(neighbour => {
      if (!visited[neighbour]) {
        visited[neighbour] = true;
        queue.push({ i: neighbour, d: current.d + 1 });
      }
    });
  }

  return 0;
};

/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
  var beginWordIndex = -1;
  var endWordIndex = -1;
  var adjList = [];

  wordList.forEach((word, i) => {
    adjList.push([]);
    if (word === endWord) {
      endWordIndex = i;
    }
    if (word === beginWord) {
      beginWordIndex = i;
    }
  });

  if (endWordIndex === -1) {
    return 0;
  }

  if (beginWordIndex === -1) {
    wordList.push(beginWord);
    beginWordIndex = wordList.length - 1;
    adjList.push([]);
  }

  for (let i = 0; i < wordList.length; i++) {
    for (let j = i + 1; j < wordList.length; j++) {
      if (isTransformation(wordList[i], wordList[j])) {
        adjList[i].push(j);
        adjList[j].push(i);
      }
    }
  }

  return shortestPath(adjList, beginWordIndex, endWordIndex);
};