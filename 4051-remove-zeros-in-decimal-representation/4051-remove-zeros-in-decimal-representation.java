class Solution {
    public long removeZeros(long n) {
        StringBuilder str = new StringBuilder();

        while(n != 0){
            long last = n % 10;
            if(last != 0)
                str.append(last);

            n /= 10;
        }
       str.reverse();
        return Long.parseLong(str.toString());
    }
}