class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
            return indicies
    Keys    2 7 11 15 - 9
    Vals    0 1  2  3

            for(i to n-1){
                check if map has target - i val.
                    return i, map.get(target - i val); 
            }

            return -1;
        */

        Map<Integer, Integer> numToIndices = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];

            if(numToIndices.containsKey(diff)) {
                return new int[] {i, numToIndices.get(diff)};
            }

            numToIndices.put(nums[i], i);
        }

        return new int[]{};
    }
}