class Solution {
    public boolean canPartition(int[] nums) {
       // get sum
       // divide by two to get target
       // try to get elements that add up to target.

       /*   
            x    1   5   11  5
            22   
        5       21   16   5  0

        11      16  11 

        5

        1       
        

       */

       if(nums.length == 0) return true;
       if(nums.length == 1) return false;

       int sum = 0; 
       for(int i: nums) sum+= i;

       if(sum % 2 == 1) return false;

        int target = sum/2;

        Boolean[][] memo = new Boolean[nums.length + 1][target + 1];
        return findSubsetForTarget(nums, target, 0, 0, memo);
    }

    private Boolean findSubsetForTarget(int[] nums, int target, int start, int acc, Boolean[][] memo){
        if(acc > target || start == nums.length) return false;

        if(acc == target) return true;

        if(memo[start][acc] != null) return memo[start][acc];

        memo[start][acc] = findSubsetForTarget(nums, target, start+1, acc+nums[start], memo) || 
        findSubsetForTarget(nums, target, start+1, acc, memo);
        return  memo[start][acc];
    }
}