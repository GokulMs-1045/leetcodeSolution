class Solution {

    private int func(int row, int col, int[][] grid, int[][]dp){
        
        if(row < 0 || col < 0)
            return Integer.MAX_VALUE;

        if(row == 0 && col == 0)
            return grid[row][col];

        if(dp[row][col] != - 1)
            return dp[row][col];

        int top = func(row - 1, col, grid, dp);
        int left = func(row, col - 1, grid, dp);

        return dp[row][col] = grid[row][col] + Math.min(top, left);
    }

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for(int[] row : dp)
            Arrays.fill(row, - 1);

        return func(m - 1, n - 1, grid, dp);
    }
}