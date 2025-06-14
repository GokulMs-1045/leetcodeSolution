class Solution {

    private boolean func(int ind, int target, int[] nums, int[][] dp){

        if(ind == 0)
            return nums[0] == target;

        if(target == 0)
            return true;

        if(dp[ind][target] != - 1)
            return dp[ind][target] == 0 ? false : true;

        boolean notTake = func(ind - 1, target, nums, dp);
        boolean take = false;

        if(target >= nums[ind])
            take = func(ind - 1, target - nums[ind], nums, dp);

        dp[ind][target] = take || notTake ? 1 : 0;

        return take || notTake;
    }

    public boolean canPartition(int[] nums) {
        
        int n = nums.length;
        int target = 0;

        for(int i = 0 ; i < n ; i++)
            target += nums[i];

        if(target % 2 == 1)
            return false;
        
        int[][] dp = new int[n][target + 1];

        for(int[] row : dp)
            Arrays.fill(row, - 1);

        return func(n - 1, target / 2 , nums, dp);
    }
}