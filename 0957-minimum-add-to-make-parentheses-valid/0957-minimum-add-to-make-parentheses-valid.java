class Solution {
    public int minAddToMakeValid(String s) {

        int n = s.length();
        
        // if(n % 2 == 1)
        //     return - 1;

        int close = 0 ;
        int open = 0;

        for(int i = 0 ; i < n ; i++){
            
            if(s.charAt(i) == '(')
                open += 1;

            if(s.charAt(i) == ')'){
                if(open > 0)
                    open -= 1;
                
                else 
                    close += 1;
            }
        }

        //return (open / 2) + (open % 2) + (close % 2);
        return open + close;
    }
}