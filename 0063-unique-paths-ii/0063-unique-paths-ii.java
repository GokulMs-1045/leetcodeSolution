class Solution {

    private int func(int m, int n, int[][]obstacleGrid, int dp[][]){

        if(m < 0 || n < 0 || obstacleGrid[m][n] == 1)
            return 0;

        if(m == 0 && n == 0)
            return 1;

        if(dp[m][n] != - 1)
            return dp[m][n];

        int top = func(m - 1, n, obstacleGrid, dp);
        int left = func(m, n - 1, obstacleGrid, dp);

        return dp[m][n] = top + left;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(m == 1 && n == 1 && obstacleGrid[0][0] == 0)
            return 1;

        if(m == 1 && n == 1 && obstacleGrid[0][0] == 1)
            return 0;

        int[][] dp = new int[m][n];

        for(int[] row : dp)
            Arrays.fill(row, - 1);

        return func(m - 1, n - 1, obstacleGrid, dp);
    }
}