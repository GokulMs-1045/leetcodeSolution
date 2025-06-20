class Solution {
    public boolean canPartition(int[] nums) {
        int totSum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++)
            totSum += nums[i];

        if (totSum % 2 == 1)
            return false;

        else {
            int k = totSum / 2;

            boolean[][] dp = new boolean[n][k + 1];

            for(int i = 0 ; i < n ; i++)
            dp[i][0] = true;

            if(nums[0] <= k)
                dp[0][nums[0]] = true;

            for(int ind = 1 ; ind < n ; ind++){
                for(int i = 1 ; i <= k ; i++){

                    boolean notTaken = dp[ind - 1][i];
                    boolean taken = false;

                    if(nums[ind] <= i)
                        taken = dp[ind - 1][i - nums[ind]];

                    dp[ind][i] = taken || notTaken;
                }
            }
            return dp[n - 1][k];
        }
    }
}