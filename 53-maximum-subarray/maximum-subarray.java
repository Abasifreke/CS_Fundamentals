class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;

        for(int i = 0; i < nums.length; i++){
            currSum = Math.max(currSum, 0) + nums[i];
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}