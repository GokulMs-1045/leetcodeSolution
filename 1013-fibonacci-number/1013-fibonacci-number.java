class Solution {
    public int fib(int n) {
        
        if(n == 1)
            return 1;

        if(n <= 0)
            return 0;

        int one = fib(n - 1);
        int two = fib(n - 2);

        return one + two;
    }
}