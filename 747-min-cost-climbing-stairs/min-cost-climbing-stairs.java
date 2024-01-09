class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length+1];

        int prevTwo = 0;
        int prevOne = 0;
        for(int i = 2; i < minCost.length; i++){
            int takeOneStep = prevOne + cost[i-1];
            int takeTwoStep = prevTwo + cost[i-2];

            int currMin = Math.min(takeOneStep, takeTwoStep);
            prevTwo = prevOne;
            prevOne = currMin;
        }
        
        return prevOne;
    }
}