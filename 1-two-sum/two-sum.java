class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valToIndex = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(valToIndex.containsKey(diff)){
                return new int[]{valToIndex.get(diff), i};
            }
            
            valToIndex.put(nums[i], i);
        }
        
        return new int[]{};
    }
}