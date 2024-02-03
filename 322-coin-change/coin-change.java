class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        HashSet<Integer> coinSet = new HashSet<>();
        for(int coin: coins){
            coinSet.add(coin);
        }

        dp[0] = 0;

        for(int i = 1; i < dp.length; i++){
            if(coinSet.contains(i)){
                dp[i] = 1;
            }else{
                for(int coin: coinSet){
                    if(coin < i){
                        dp[i] = Math.min(dp[i], (1 + dp[(i - coin)]));
                    }
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}