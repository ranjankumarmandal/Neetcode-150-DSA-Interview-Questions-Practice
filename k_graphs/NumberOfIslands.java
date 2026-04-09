public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }
}