/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    int r[] = { -1, 0, 1, 0 };
    int c[] = { 0, -1, 0, 1 };

    public void dfs(int i, int j, char[][] grid) {

        grid[i][j] = '0';

        for (int d = 0; d < 4; d++) {
            int nr = i + r[d];
            int nc = j + c[d];

            // within grid
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length) {

                // valid position
                if (grid[nr][nc] == '1') {
                    dfs(nr, nc, grid);
                }
            }
        }

    }
}
// @lc code=end
