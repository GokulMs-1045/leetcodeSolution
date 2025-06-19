class Solution {
    public int minFallingPathSum(int[][] matrix) {
         int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for(int row = 1 ; row < m ; row++){
            for(int col = 0 ; col < n ; col++){

                int up = 0;
                int upLeft = Integer.MAX_VALUE;
                int upRight = Integer.MAX_VALUE;


                if(row > 0)
                    up = matrix[row][col] + dp[row - 1][col];

                if(col - 1 >= 0)
                    upLeft = matrix[row][col] + dp[row - 1][col - 1];

                if(col + 1 < n)
                    upRight = matrix[row][col] + dp[row - 1][col + 1];

                dp[row][col] = Math.min(up, Math.min(upLeft, upRight));
            }
        }

        int mini = Integer.MAX_VALUE;

        for(int j = 0 ; j < n ; j++){
            
            int ans = dp[m - 1][j];
            mini = Math.min(mini, ans);
        }

        return mini;
    }
}