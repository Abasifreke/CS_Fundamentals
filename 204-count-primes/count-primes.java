class Solution {
    public int countPrimes(int n) {
        boolean[] dp = new boolean[n];
        // Arrays.fill(dp, -1);

        int count = 0;
        for(int i = 2; i < n; i++){

            if(dp[i] == false){
                count++;
                // dp[i] = i;

                int j = 2;
                while(i * j < n){
                    if(!dp[i*j]){
                        dp[i*j] = true;
                    }
                    j++;
                }
            }
        }

        return count;
    }
}