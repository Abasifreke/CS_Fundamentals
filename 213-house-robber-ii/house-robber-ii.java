class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(rob1(nums, 0, n-2), rob1(nums, 1, n-1));
    }

    public int rob1(int[] nums, int start, int end) {
        int n = nums.length;

        if(n == 1) return nums[start];
        
        int twoNaway = nums[start];
        int oneNaway = Math.max(nums[start], nums[start + 1]);

        for(int i = start + 2; i <= end; i++){
            int iThAnswer = Math.max(oneNaway, nums[i] + twoNaway);
            twoNaway = oneNaway;
            oneNaway = iThAnswer;
        }

        return oneNaway;
    }
}