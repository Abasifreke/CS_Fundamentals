class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        
        // int[] robbed = new int[nums.length];
        // robbed[0] = nums[0];
        // robbed[1] = Math.max(nums[0], nums[1]);

        int oneHouseAgo = Math.max(nums[0], nums[1]);
        int twoHousesAgo = nums[0];
        
        for(int i = 2; i < nums.length; i++ ){
            // robbed[i] = Math.max(nums[i] + robbed[i-2], robbed[i-1]);
            int maxRobbed = Math.max(nums[i] + twoHousesAgo, oneHouseAgo);
            twoHousesAgo = oneHouseAgo;
            oneHouseAgo = maxRobbed;
        }
        // System.out.println(Arrays.toString(robbed));
        // return Math.max(robbed[robbed.length-1], robbed[robbed.length-2]);
        return oneHouseAgo;
    }
}