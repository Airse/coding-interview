class Solution {
  public List<List<String>> solveNQueens(int n) {
    int[] queens = new int[n];
    return solveNQueens(queens, 0, n);
  }

  public List<String> generateBoard(int[] queens, int n) {
    List<String> board = new ArrayList<String>();

    for (int i = 0; i < n; i++) {
      String row = "";
      for (int j = 0; j < n; j++) {
        if (queens[i] == j) {
          row += "Q";
        } else {
          row += ".";
        }
      }
      board.add(row);
    }

    return board;
  }

  public List<List<String>> solveNQueens(int[] queens, int row, int n) {
    List<List<String>> result = new ArrayList<List<String>>();

    if (row >= n) {
      result.add(generateBoard(queens, n));
      return result;
    }

    for (int col = 0; col < n; col++) {
      boolean canUseCol = true;
      // check rows and diagonals
      for (int q = 0; q < row; q++) {
        if (queens[q] == col) {
          canUseCol = false;
          break;
        }
        if (queens[q] == col - (row - q) || queens[q] == col + (row - q)) {
          canUseCol = false;
          break;
        }
      }
      if (canUseCol) {
        queens[row] = col;
        result.addAll(solveNQueens(queens, row + 1, n));
      }
    }

    return result;
  }
}