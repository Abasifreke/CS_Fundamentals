class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];

        for(int i = 0; i < cost.length; i++){
            if(i < 2){
                minCost[i] = cost[i];
                continue;
            }

            minCost[i] = Math.min(cost[i] + minCost[i-2], cost[i] + minCost[i-1]);
        }

        return  Math.min(minCost[cost.length-1], minCost[cost.length-2]);
    }
}