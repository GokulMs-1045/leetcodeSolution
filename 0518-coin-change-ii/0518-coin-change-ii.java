class Solution {
    private int func(int[] arr, int ind, int T, int[][] dp) {

        if (ind == 0) 
            return (T % arr[0] == 0) ? 1 : 0;

        if (dp[ind][T] != -1)
            return (int)dp[ind][T];

        int notTaken = func(arr, ind - 1, T, dp);

        int taken = 0;
        if (arr[ind] <= T)
            taken = func(arr, ind, T - arr[ind], dp);

        return dp[ind][T] = notTaken + taken;
    }

    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length][amount + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return func(coins, coins.length - 1, amount, dp);
    }
}