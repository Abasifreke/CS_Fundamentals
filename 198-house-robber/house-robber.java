class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int first = nums[0];
        int second = Math.max(first, nums[1]);

        for(int i = 2; i < nums.length; i++){
            int temp = Math.max(nums[i] + first, second);
            first = second;
            second = temp;
        }

        return Math.max(second, first);
    }
}