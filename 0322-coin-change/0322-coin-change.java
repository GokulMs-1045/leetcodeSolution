class Solution {

    private int func(int ind, int target, int[] coins, int[][] dp){

        if(target == 0)
            return 0;

        if(ind == 0){

            if(target % coins[0] == 0)
                return target / coins[0];

            else
                return (int) 1e9;
        }

        if(dp[ind][target] != - 1)
            return dp[ind][target];

        int notPick = 0 + func(ind - 1, target, coins, dp);
        int pick = (int) 1e9;

        if(target >= coins[ind])
            pick = 1 + func(ind, target - coins[ind], coins, dp);

        dp[ind][target]= Math.min(pick, notPick);

        return dp[ind][target];
    }

    public int coinChange(int[] coins, int amount) {
        
        int[][] dp = new int[coins.length][amount + 1];

        for(int[] row : dp)
            Arrays.fill(row, - 1);

        int ans =  func(coins.length - 1 , amount , coins, dp);

        if (ans >= (int)1e9)
            return -1;

        return ans;
    }
}