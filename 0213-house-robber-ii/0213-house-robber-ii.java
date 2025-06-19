class Solution {

    private int func(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            
            int pick = nums[i];

            if (i > 1)
                pick += dp[i - 2];

            int nonPick = dp[i - 1];

            dp[i] = Math.max(pick, nonPick);
        }

        return dp[n - 1];
    }

    public int rob(int[] nums) {

         int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];

        int[] arr1 = new int[n - 1];
        int[] arr2 = new int[n - 1];

        for (int i = 0; i < n; i++) {
            if (i != n - 1)
                arr1[i] = nums[i];
            if (i != 0)
                arr2[i - 1] = nums[i];
        }
        int ans1 = func(arr1);

        int ans2 = func(arr2);

        return Math.max(ans1, ans2);
    }
}