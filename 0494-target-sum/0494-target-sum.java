class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int mod = (int) 1e9 + 7;
        int n = nums.length;
        int totSum = 0;

        for (int i = 0; i < nums.length; i++)
            totSum += nums[i];

        if (totSum - target < 0)
            return 0;
            
        if ((totSum - target) % 2 == 1) 
            return 0;

        int s2 = (totSum - target) / 2;

        int[][] dp = new int[n][s2 + 1];

        for(int i = 0 ; i < nums.length ; i++)
            dp[i][0] = 1;

        if(nums[0] <= s2)
            dp[0][nums[0]] = 1;

        if (nums[0] == 0)
            dp[0][0] = 2;  // +0 and -0

        for(int ind = 1 ; ind < nums.length ; ind++){
            for(int val = 0 ; val <= s2 ; val++){

                int notTaken = dp[ind - 1][val];

                int taken = 0;

                if (nums[ind] <= val)
                    taken = dp[ind - 1][val - nums[ind]];

                dp[ind][val] = (notTaken + taken) % mod;
            }
        }

        return dp[nums.length - 1][s2];
    }
}