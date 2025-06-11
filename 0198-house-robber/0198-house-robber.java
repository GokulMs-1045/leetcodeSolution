class Solution {

    private int func(int ind, int[] nums, int[] dp){

        if(ind == 0)
            return nums[ind];

        if(ind < 0)
            return 0;

        if(dp[ind] != - 1)
            return dp[ind];

        int left = nums[ind] + func(ind - 2, nums, dp);
        int right = 0 + func(ind - 1, nums, dp);

        return dp[ind] = Math.max(left, right);
    }

    public int rob(int[] nums) {

        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, - 1);

        return func(nums.length - 1, nums, dp);
    }
}