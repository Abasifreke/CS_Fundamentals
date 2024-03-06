class Solution {
    public void moveZeroes(int[] nums) {
        int l = nums.length;
        int nonZ = 0;
        
        for(int i = 0; i < l; i++){
            if(nums[i] != 0){
                nums[nonZ++] = nums[i];
            }
        }
        
        for(int i = nonZ; i < l; i++){
            nums[i] = 0;
        }
    }
}