class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;

                if (row == 0 && col == 0) {
                    dp[row][col] = grid[row][col];
                    continue;
                }

                if (row > 0)
                    up = grid[row][col] + dp[row - 1][col];

                if (col > 0)
                    left = grid[row][col] + dp[row][col - 1];

                dp[row][col] = Math.min(up, left);
            }
        }

        return dp[m - 1][n - 1];
    }
}