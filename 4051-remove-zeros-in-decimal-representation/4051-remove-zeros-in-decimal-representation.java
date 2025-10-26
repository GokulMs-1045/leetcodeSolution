class Solution {
    public long removeZeros(long n) {
        
        long res = 0, mult = 1;
        while(n != 0){
           long last = n % 10;
            if(last != 0){
                res += last * mult;
                mult *= 10;
            }
            n /= 10;
        }
        return res;
    }
}