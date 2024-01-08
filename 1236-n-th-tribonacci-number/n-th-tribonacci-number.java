class Solution {
    public int tribonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        
        if(n == 0){ return a;}
        if(n == 1){return b;}
        if(n == 2){return c;}

        int accumulator = 0;
        for(int i = 3; i <= n; i++){
            accumulator = c + b + a;
            a = b;
            b = c;
            c = accumulator;
        }

        return accumulator;
    }
}