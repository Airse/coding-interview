class Solution {
  private static int[] ROW_ADJ = { -1, 0, 0, 1 };
  private static int[] COL_ADJ = { 0, -1, 1, 0 };

  private boolean isValidCell(int r, int c, int n, int m) {
    return !(r < 0 || r >= n || c < 0 || c >= m);
  }

  private boolean isEdgeCell(int r, int c, int n, int m) {
    return (r == 0 || c == 0 || r == n - 1 || c == m - 1);
  }

  private void flipOs(char[][] board, boolean[][] visited, int r, int c, int n, int m) {
    Queue<Cell> q = new LinkedList<Cell>();
    Queue<Cell> oRegion = new LinkedList<Cell>();

    q.offer(new Cell(r, c));
    visited[r][c] = true;

    boolean hasEdgeCell = false;
    while (!q.isEmpty()) {
      Cell current = q.poll();
      oRegion.offer(current);

      if (isEdgeCell(current.r, current.c, n, m)) {
        hasEdgeCell = true;
      }

      // add neighbours
      for (int i = 0; i < ROW_ADJ.length; i++) {
        int neighbourRow = current.r + ROW_ADJ[i];
        int neighbourCol = current.c + COL_ADJ[i];
        if (isValidCell(neighbourRow, neighbourCol, n, m) &&
            !visited[neighbourRow][neighbourCol] &&
            board[neighbourRow][neighbourCol] == 'O') {
          visited[neighbourRow][neighbourCol] = true;
          q.offer(new Cell(neighbourRow, neighbourCol));
        }
      }
    }

    if (!hasEdgeCell) { // the Os are surrounded, so flip
      while (!oRegion.isEmpty()) {
        Cell current = oRegion.poll();
        board[current.r][current.c] = 'X';
      }
    }
  }

  public void solve(char[][] board) {
    int n = board.length;

    if (n == 0) {
      return;
    }

    int m = board[0].length;

    boolean[][] visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j] && board[i][j] == 'O') {
          flipOs(board, visited, i, j, n, m);
        }
      }
    }
  }
}

class Cell {
  int r;
  int c;

  public Cell(int r, int c) {
    this.r = r;
    this.c = c;
  }
}