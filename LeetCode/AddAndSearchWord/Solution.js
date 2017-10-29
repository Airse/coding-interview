var TrieNode = function () {
  this.children = {};
  this.isEnd = false;
};

/**
 * Initialize your data structure here.
 */
var WordDictionary = function () {
  this.head = new TrieNode();
};

/**
 * Adds a word into the data structure. 
 * @param {string} word
 * @return {void}
 */
WordDictionary.prototype.addWord = function (word) {
  addWordRec(this.head, word, 0);

  function addWordRec(node, word, index) {
    if (index >= word.length) {
      node.isEnd = true;
      return;
    }

    let c = word[index];
    if (!node.children[c]) {
      node.children[c] = new TrieNode();
    }

    addWordRec(node.children[c], word, index + 1);
  }
};

/**
 * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. 
 * @param {string} word
 * @return {boolean}
 */
WordDictionary.prototype.search = function (word) {
  return searchRec(this.head, word, 0);

  function searchRec(node, word, index) {
    if (node === undefined) {
      return false;
    }
    if (index >= word.length) {
      return node.isEnd;
    }

    let c = word[index];
    if (c === '.') {
      let found = false;
      for (let child of Object.keys(node.children)) {
        found = found || searchRec(node.children[child], word, index + 1);
        if (found) {
          break;
        }
      }

      return found;
    }

    return searchRec(node.children[c], word, index + 1);
  }
};

/** 
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = Object.create(WordDictionary).createNew()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */