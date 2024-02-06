class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length -1;

        while(l <= r){
            int middle = l + (r - l)/2;

            if(nums[middle] == target) return middle;

            if(nums[l] <= nums[middle]){
                if(target < nums[l] || target > nums[middle]){
                    l = middle + 1;
                }else {
                    r = middle - 1;
                }
            }else{
                if(target > nums[middle] && target <= nums[r]){
                    l = middle + 1;
                }else{
                    r = middle -1;
                }
            }
        }   

        return -1;
    }
}