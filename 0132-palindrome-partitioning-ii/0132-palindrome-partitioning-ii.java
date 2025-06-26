class Solution {

    private boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    private int func(int i, int n, String str, int[]dp){

        if(i == n)
            return 0;

        if(dp[i] != - 1)
            return dp[i];

        int min = Integer.MAX_VALUE;

        for(int j = i ; j < n ; j++){

            if(isPalindrome(i, j, str)){

                int cost = 1 + func(j + 1, n, str, dp);
                min = Math.min(min, cost);
            }
        }

        return dp[i] = min;
    }

    int minCut(String s) {
        //your code goes here

        int n = s.length();
        int [] dp = new int[n + 1];

        dp[n] = 0;

        for(int i = n - 1 ; i >= 0 ; i--){

            int minCost = Integer.MAX_VALUE;
            
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, s)) {

                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }

            dp[i] = minCost;
        }

       return dp[0] - 1;
    }
}