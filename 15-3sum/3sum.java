class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
               
            twoSum(nums, i, result);
        }

        return result;
    }

    private void twoSum(int[] nums, int seedIndex, List<List<Integer>> acc){
        int seed = nums[seedIndex];
        int target = -seed;
        int left = seedIndex + 1;
        int right = nums.length - 1;

        while(left < right){
            if(left > seedIndex + 1 && nums[left] == nums[left-1]){
                left++;
                continue;
            }

            int sum = nums[left] + nums[right];
            if(sum == target){
                acc.add(new ArrayList<>(Arrays.asList(seed, nums[left], nums[right])));
                left++;
                right--;
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
    }
}