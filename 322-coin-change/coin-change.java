class Solution {

    /*
     set - look up for coins.

    Input: coins = [1,2,5], amount = 11
    1+1+1..... = 11
    2+.... 1 = 11
    5 + 5 + 1 + 11

    Output: 3
    Explanation: 11 = 5 + 5 + 1

    Fn = F(n-1) + F(n-2);

    Fa = F(b) + F(c);
    Fo = []
    F1 = [z]
    F[a]
    

    size = [amount + 1]
    [1,2,5], 11


  // 0 -> 0
        // 1 -> 0, 1
        // 2 -> 0, 1, 1
        // 3 -> (2, 2)
        // 4 -> (3, 2)
        // 5 -> (3, 3, 1)
        // Fn = min(candidates)
        //     = min(1 + F(a - m))

         0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
     Fn=[0, 1, 1, 2, 2, 1.......]   
    for(int i = 1; i <= amount; i++){
        int min = Integer.MAX_VALUE;
        for(coin m: coinsSet()){
            if(m <= i){
                min = Math.min(min, 1 + f(i - m));
            }
        }
    }

    return f(n);

    

    */
    public int coinChange(int[] coins, int amount) {

        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;

        for(int i = 1; i <= amount; i++){
            // build out memo - for ever i, get it's mininum number of coins;
            for(int coin: coins){
                if(coin <= i){
                    memo[i] = Math.min(memo[i], 1 + memo[i - coin]);
                }
            }
        }   

        return memo[amount] > amount ? -1 : memo[amount];
    }
}