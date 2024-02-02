class Solution {
    public int countPrimes(int n) {
        int[] dp = new int[n];
        // Arrays.fill(dp, -1);

        int count = 0;
        for(int i = 2; i < n; i++){

            if(dp[i] == 0){
                count++;
                dp[i] = i;

                int j = 2;
                while(i * j < n){
                    if(dp[i*j] == 0){
                        dp[i*j] = i;
                    }
                    j++;
                }
            }
        }

        return count;
    }
}