class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;

        if(n == 0 || n == 1) return a;

        if(n == 2) return b;

        int accumulator = 0;
        for(int i = 3; i <= n; i++){
            accumulator = b + a;
            a = b;
            b = accumulator;
        }

        return accumulator;
    }
}