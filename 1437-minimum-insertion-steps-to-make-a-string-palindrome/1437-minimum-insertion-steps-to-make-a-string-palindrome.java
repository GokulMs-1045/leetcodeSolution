class Solution {
    private int func(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Declare a 2D DP array to store length of the LCS
        int[][] dp = new int[n + 1][m + 1];

        // Initialize first row and first column to 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        // Fill in the DP array
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                } else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }
        // The value at dp[n][m] contains length of the LCS
        return dp[n][m];
    }

    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();

        return func(s, t);
    }
    public int minInsertions(String s) {
        int n = s.length();
        int k = longestPalindromeSubseq(s);

        return n - k;
    }
}