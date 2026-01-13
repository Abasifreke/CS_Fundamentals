class Solution {
    public void moveZeroes(int[] nums) {
        int l = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[l+1] = nums[i];
                l++;
            }
        }

        l++;
        for(; l < nums.length; l++){
            nums[l] = 0;
        }


        /*

        l = -1;
        i = 0
        [0,1,0,3,12]

        l = -1;
        i = 1
        [1,1,0,3,12]
        l = 0;

        l = 0;
        i = 3
        [1,3,0,3,12]
        l = 1;


        l = 1;
        i = 5
        [1,3,12,3,12]
        l = 3;
        */
    }
}