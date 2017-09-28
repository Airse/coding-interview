class Solution {
  public int calculateMinimumHP(int[][] dungeon) {
    int n = dungeon.length;
    int m = dungeon[0].length;
    int[][] healthNeeded = new int[n][m];

    for (int r = n - 1; r >= 0; r--) {
      for (int c = m - 1; c >= 0; c--) {
        int min = 0;
        
        if (r != n - 1 || c != m - 1) {
          min = 10000000;
          if (c + 1 < m) { // right
            min = Math.min(min, healthNeeded[r][c + 1]);
          }
          if (r + 1 < n) { // down
            min = Math.min(min, healthNeeded[r + 1][c]);
          }
        }

        min += (dungeon[r][c] * -1); 

        if (min < 0) {
          min = 0;
        }

        healthNeeded[r][c] = min;
      }
    }

    return healthNeeded[0][0] + 1;
  }
}