class Solution {
    public long MOD = (long)1e9 + 7;

    public int change(int amount, int[] coins) {
        int N = coins.length;
        int[][] dp = new int[N][amount + 1];

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = 1;
        }

        for (int ind = 1; ind < N; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notTaken = dp[ind - 1][target];
                int taken = 0;

                if (coins[ind] <= target)
                    taken = dp[ind][target - coins[ind]];

                dp[ind][target] = (notTaken + taken);
            }
        }
        
        return dp[N - 1][amount];
    }
}
