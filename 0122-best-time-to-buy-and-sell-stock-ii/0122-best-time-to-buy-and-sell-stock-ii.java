class Solution {

        private int func(int ind, int buy, int n, int[] arr, int[][] dp){

        if(ind == n)
            return 0;

        if (dp[ind][buy] != -1) 
            return dp[ind][buy];
        

        int profit = 0;

        if(buy == 0)
            profit = Math.max(0 + func(ind + 1, 0, n, arr, dp), (-1) * arr[ind] + func(ind + 1, 1, n, arr, dp));

        if(buy == 1)
            profit = Math.max(0 + func(ind + 1, 1, n, arr, dp), arr[ind] + func(ind + 1, 0, n, arr, dp));

        return dp[ind][buy] = profit;
    }
    
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        if(n == 0)
            return 0;

        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return func(0, 0, n, prices, dp);
    }
}