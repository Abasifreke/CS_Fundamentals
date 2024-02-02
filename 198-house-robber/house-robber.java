class Solution {
    public int rob(int[] nums) {
        int n = nums.length;;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int dp1 = nums[0];
        int dp2 = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++){
            int sum = Math.max(nums[i] + dp1, dp2);
            dp1 = dp2;
            dp2 = sum;
        }

        return dp2;
    }
}