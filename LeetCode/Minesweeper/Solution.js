var isValidCell = function (r, c, n, m) {
  return !(r < 0 || r >= n || c < 0 || c >= m);
};

const ADJ_ROW = [-1, -1, -1, 0, 0, 1, 1, 1];
const ADJ_COL = [-1, 0, 1, -1, 1, -1, 0, 1];

var floodBoard = function(r, c, n, m, board) {
  if (isValidCell(r, c, n, m)) {
    if (board[r][c] === 'M') {
      board[r][c] = 'X';
    } else if (board[r][c] === 'E') {
      let countBomb = 0;

      for (let i = 0; i < ADJ_ROW.length; i += 1) {
        const nextR = r + ADJ_ROW[i];
        const nextC = c + ADJ_COL[i];
        if (isValidCell(nextR, nextC, n, m) && board[nextR][nextC] === 'M') {
          countBomb += 1;
        }
      }

      if (countBomb > 0) {
        board[r][c] = countBomb + '';
      } else {
        board[r][c] = 'B';

        for (let i = 0; i < ADJ_ROW.length; i += 1) {
          const nextR = r + ADJ_ROW[i];
          const nextC = c + ADJ_COL[i];

          if (isValidCell(nextR, nextC, n, m) && board[nextR][nextC] === 'E') {
            floodBoard(nextR, nextC, n, m, board);
          }
        }
      }
    }
  }
};

/**
 * @param {character[][]} board
 * @param {number[]} click
 * @return {character[][]}
 */
var updateBoard = function (board, click) {
  let n = board.length;
  let m = board[0].length;
  let r = click[0];
  let c = click[1];

  floodBoard(r, c, n, m, board);

  return board;
};
