class Solution {

    private int func(int row, int col1, int col2, int m, int n, int[][] matrix, int[][][] dp){

        if (col1 < 0 || col1 >= n || col2 < 0 || col2 >= n)
            return (int)(-1e9);

        if(row ==  m - 1){

            if(col1 == col2)
                return matrix[row][col1];

            else 
                return matrix[row][col1] + matrix[row][col2];
        }

        if(dp[row][col1][col2] != - 1)
            return dp[row][col1][col2];

        int max = Integer.MIN_VALUE;

        for(int i = - 1 ; i <= 1 ; i++){
            for(int j = - 1 ; j <= 1; j++){

                int ans;

                if (col1 == col2)
                    ans = matrix[row][col1];
                else
                    ans = matrix[row][col1] + matrix[row][col2];

                int next = func(row + 1, col1 + i, col2 + j, m, n, matrix, dp);

                // Update the maximum result
                max = Math.max(max, ans + next);
            }
        }
        return dp[row][col1][col2] = max;
    }

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][][] = new int[m][n][n];

        // Initialize the dp array with -1
        for (int row1[][] : dp) {
            for (int row2[] : row1) {
                Arrays.fill(row2, -1);
            }
        }

        return func(0, 0, n - 1, m, n, grid, dp);
    }
}