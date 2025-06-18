class Solution {

        private int func(int ind, int buy, int cap, int n, int[] arr, int[][][] dp){

        if(ind == n || cap == 0)
            return 0;

        if (dp[ind][buy][cap] != -1) 
            return dp[ind][buy][cap];
        

        int profit = 0;

        if(buy == 0)
            profit = Math.max(0 + func(ind + 1, 0, cap, n, arr, dp), (-1) * arr[ind] + func(ind + 1, 1, cap, n, arr, dp));

        if(buy == 1)
            profit = Math.max(0 + func(ind + 1, 1, cap, n, arr, dp), arr[ind] + func(ind + 1, 0, cap - 1, n, arr, dp));

        return dp[ind][buy][cap] = profit;
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;

         if (n == 0) 
            return 0;

        int[][][] dp = new int[n][2][3];
        
        // Initialize the dp array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int ans = func(0, 0, 2, n, prices, dp);
        
        // Return the maximum profit
        return ans;
    }
}