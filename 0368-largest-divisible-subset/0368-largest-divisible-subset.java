class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
      List<Integer> ans = new ArrayList<>();
      int []dp = new int[n];
      int []parent = new int[n];
      int maxLen = 0;
      int lastIndex = 0;
    Arrays.sort(nums);
      Arrays.fill(dp, 1);

      for(int i = 0 ; i < n ; i++){
        parent[i] = i;

        for(int prevInd = 0 ; prevInd < i ; prevInd++){
            
          if(nums[i] % nums[prevInd] == 0 && dp[i] < dp[prevInd] + 1){
            
            dp[i] = dp[prevInd] + 1;
            parent[i] = prevInd;
          }
        }

        if(dp[i] > maxLen){
          lastIndex = i;
          maxLen = dp[i];
        }
      }

      int i = lastIndex;

      while(parent[i] != i){
        ans.add(nums[i]);
        i = parent[i];
      }
      ans.add(nums[i]);

      Collections.reverse(ans);

      return ans;
    }
}