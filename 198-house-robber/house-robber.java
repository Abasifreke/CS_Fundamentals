class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        
        // first adjecent houses. Order looks like... twoHousesAgo | oneHouseAgo | current house | next house... etc.
        int oneHouseAgo = Math.max(nums[0], nums[1]);
        int twoHousesAgo = nums[0];
        
        // build bottom up solution with only two variables to store last two houses' max robbed.
        for(int i = 2; i < nums.length; i++ ){
            int maxRobbed = Math.max(nums[i] + twoHousesAgo, oneHouseAgo);
            twoHousesAgo = oneHouseAgo;
            oneHouseAgo = maxRobbed;
        }
      
        return oneHouseAgo;
    }
}