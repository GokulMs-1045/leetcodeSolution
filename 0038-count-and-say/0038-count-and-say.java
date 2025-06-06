class Solution {
    public String countAndSay(int n) {
        
        if(n == 1)
            return "1";

        String prev = countAndSay(n - 1);
        StringBuilder ans = new StringBuilder();
        int len = prev.length();
        int count = 1;

        for(int i = 1 ; i < len ; i++){

            if(prev.charAt(i) == prev.charAt(i - 1))
                count += 1;

            else{

                ans.append(count);
                ans.append(prev.charAt(i - 1));
                count = 1;
            }
        }

        ans.append(count);
        ans.append(prev.charAt(len - 1));

        return ans.toString();
    }
}