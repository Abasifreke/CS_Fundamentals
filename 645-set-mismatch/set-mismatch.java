class Solution {
    public int[] findErrorNums(int[] nums) {
        //[2,2]
        //[2,-2]
        int dup = 0;
        for(int i = 0; i < nums.length; i++){
            int curr = Math.abs(nums[i]);

            if(nums[curr-1] < 0){
                dup = curr;
            }
            nums[curr-1] *= -1;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0 && i+1 != dup){
                return new int[]{dup, i+1};
            }
        }

        return new int[]{0};
    }

}