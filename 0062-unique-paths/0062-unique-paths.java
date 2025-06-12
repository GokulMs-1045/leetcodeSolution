class Solution {

    private int func(int m, int n, int dp[][]){

        if(m == 1 && n == 1)
            return 1;

        if(m < 0 || n < 0)
            return 0;

        if(dp[m][n] != - 1)
            return dp[m][n];

        int top = func(m - 1, n, dp);
        int left = func(m, n - 1, dp);

        return dp[m][n] = top + left;
    }

    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m + 1][n + 1];

        for(int[] row : dp)
            Arrays.fill(row, - 1);

        return func(m, n, dp);
    }
}