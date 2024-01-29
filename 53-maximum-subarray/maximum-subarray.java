class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int sum = 0, maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            sum = sum < 0 ? nums[i] : sum + nums[i];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}