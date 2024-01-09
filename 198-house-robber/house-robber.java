class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        

        int oneHouseAgo = Math.max(nums[0], nums[1]);
        int twoHousesAgo = nums[0];
        
        for(int i = 2; i < nums.length; i++ ){
            int maxRobbed = Math.max(nums[i] + twoHousesAgo, oneHouseAgo);
            twoHousesAgo = oneHouseAgo;
            oneHouseAgo = maxRobbed;
        }
      
        return oneHouseAgo;
    }
}