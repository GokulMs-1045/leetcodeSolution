class Solution {

    private int func(int ind, int buy, int fee, int n, int[] arr, int[][] dp){

        if(ind == n)
            return 0;

        if (dp[ind][buy] != -1) 
            return dp[ind][buy];
        

        int profit = 0;

        if(buy == 0)
            profit = Math.max(0 + func(ind + 1, 0, fee, n, arr, dp), (-1) * arr[ind] + func(ind + 1, 1, fee, n, arr, dp));

        if(buy == 1)
            profit = Math.max(0 + func(ind + 1, 1, fee, n, arr, dp), arr[ind] - fee + func(ind + 1, 0, fee, n, arr, dp));

        return dp[ind][buy] = profit;
    }

    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;

        if (n == 0) 
            return 0;
            
        // Declare a DP table to memoize results
        int[][] dp = new int[n][2];
        
        // Initialize the dp array with -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = func(0, 0, fee, n, prices, dp);
        
        // Return the maximum profit
        return ans;
    }
}