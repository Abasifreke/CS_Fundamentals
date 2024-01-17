class Solution {
    public int rob(int[] nums) {
        
        /*
            [2,7,9,3,1] 
            [1, 3, 2, 1]

            //[1, max(1,2), max(i-1, val(i) + i-2),  val(i) + i-2), val(i) + i-2)]
            [2,7,11,11,12] 
            [1, 3, 3, 4] = 4
        */
        int n = nums.length;

        if(n == 1) return nums[0];
        
        int twoNaway = nums[0];
        int oneNaway = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++){
            int iThAnswer = Math.max(oneNaway, nums[i] + twoNaway);
            twoNaway = oneNaway;
            oneNaway = iThAnswer;
        }

        return oneNaway;
    }
}