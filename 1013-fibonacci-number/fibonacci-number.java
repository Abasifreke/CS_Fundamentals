class Solution {
    public int fib(int n) {
        int a = 0;
        int b = 1;

        if(n == 0) return a;

        if(n == 1) return b;

        int accumulator = 0;
        for(int i = 2; i <= n; i++){
            accumulator = b + a;
            a = b;
            b = accumulator;
        }

        return accumulator;
    }
}