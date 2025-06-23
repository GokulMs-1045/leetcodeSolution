class Solution {
        private boolean checkPossible(String s, String t){

        if(s.length() != t.length() + 1)
            return false;

        int i = 0; 
        int j = 0;

        while(i < s.length()){

            if(j < t.length() && s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }
            else
                i++;
        }

        return (i == s.length() && j == t.length());
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        int maxLen = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i; j++){

                if(checkPossible(words[i], words[j]) && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }

            if(dp[i] > maxLen)
                maxLen = dp[i];
        }

        return maxLen;
    }
}