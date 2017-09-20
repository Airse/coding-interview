import java.util.*;

public class Solution {
  private static final int[] ADJ_ROW = { -1, -1, -1, 0, 0, 1, 1, 1 };
  private static final int[] ADJ_COL = { -1, 0, 1, -1, 1, -1, 0, 1 };

  private static boolean isValidCell(int i, int j, int n, int m, int[][] grid) {
    return !(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0);
  }

  private static int getRegionSize(int startR, int startC, int n, int m, int[][] grid, boolean[][] visited) {
    Queue<Cell> q = new LinkedList<Cell>();

    q.offer(new Cell(startR, startC));
    visited[startR][startC] = true;

    int regionSize = 0;
    while (!q.isEmpty()) {
      regionSize++;
      Cell cell = q.poll();

      for (int i = 0; i < ADJ_ROW.length; i++) {
        int nextR = cell.r + ADJ_ROW[i];
        int nextC = cell.c + ADJ_COL[i];
        if (isValidCell(nextR, nextC, n, m, grid)) {
          if (visited[nextR][nextC]) {
            continue;
          }
          visited[nextR][nextC] = true;
          q.offer(new Cell(nextR, nextC));
        }
      }
    }

    return regionSize;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();

    int[][] grid = new int[n][m];
    boolean[][] visited = new boolean[n][m];

    for (int grid_i = 0; grid_i < n; grid_i++) {
      for (int grid_j = 0; grid_j < m; grid_j++) {
        grid[grid_i][grid_j] = in.nextInt();
      }
    }

    int maxRegionSize = 0;
    for (int grid_i = 0; grid_i < n; grid_i++) {
      for (int grid_j = 0; grid_j < m; grid_j++) {
        if (!visited[grid_i][grid_j] && grid[grid_i][grid_j] == 1) {
          maxRegionSize = Math.max(maxRegionSize, getRegionSize(grid_i, grid_j, n, m, grid, visited));
        }
      }
    }

    System.out.println(maxRegionSize);

    in.close();
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