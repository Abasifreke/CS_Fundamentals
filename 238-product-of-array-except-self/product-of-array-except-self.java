class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = 1;

        int accumulator = nums[0];
        for(int i = 1; i < n; i++){
            prefix[i] = accumulator;
            accumulator *= nums[i];
        }

        // [1, 2 ,3, 4]
        // [1, 1, 2, 6]
        // 24
        // [24, 12,8, 6]
        int[] result = new int[n];
        
        accumulator = 1;
        for(int i = n-1; i >= 0; i--){
            result[i] = accumulator * prefix[i];
            accumulator *= nums[i];
        }

        return result;
    }
}