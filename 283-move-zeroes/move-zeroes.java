class Solution {
    public void moveZeroes(int[] nums) {
        int zIndex = 0, l = nums.length;
        int nonZ = 0;
        
        for(int i = 0; i < l; i++){
            if(nums[i] == 0){
                nonZ = Math.max(i, nonZ);
                while(nonZ < l && nums[nonZ] == 0){
                    nonZ++;
                }
                
                if(nonZ == l) return;
                
                nums[i] = nums[nonZ];
                nums[nonZ] = 0;
            }
        }
        
    }
}