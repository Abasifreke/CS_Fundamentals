class Solution {
    public int countPrimes(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        /*
            n = 10
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
            1, 2,-1, 2, -1,2, -1,2, -1, 2
            1, 2, 3,   ,-1,  , -1, , 3, 2
            1, 2, 3,   5        
        */

        int count = 0;
        for(int i = 2; i < n; i++){

            if(dp[i] == -1){
                count++;
                dp[i] = i;

                int j = 2;
                while(i * j < n){
                    if(dp[i*j] == -1 ){
                        dp[i*j] = i;
                    }
                    j++;
                }
            }
        }

        return count;
    }
}