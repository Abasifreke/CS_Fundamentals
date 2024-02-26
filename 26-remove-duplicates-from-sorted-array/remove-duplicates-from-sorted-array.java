class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        
        /*
            keep track of two pointer
            if left is same as left -1, move right till we get differnt value, then swap
            move left by 1. move right by 1. stop when right == end of array
            [0,0,1,1,1,2,2,3,3,4]
            
            [0,0,1,1,1,2,2,3,3,4]
        */
        int curr = nums[0];
        while(right < nums.length){
            if(nums[left] != nums[right]){
                swap(nums, ++left, right);
            }
            right++;
        }
        return left+1;
    }
    
    private void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}