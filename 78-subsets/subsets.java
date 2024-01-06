class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        /*
            Input: nums = [1,2,3]
            Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]


        */
        powerSet(nums, 0, result, new ArrayList<Integer>());

        return result;
    }

    public void powerSet(int[] nums, int start, List<List<Integer>> result, List<Integer> accumulator){

        if(start == nums.length){
            result.add(new ArrayList<>(accumulator));
            return;
        }

        // don't choose start
        // List<Integer> accumulatorWithout = new ArrayList<>(accumulator);
        // powerSet(nums, start +1, result, accumulator);

        // choosing start
        accumulator.add(nums[start]);
        powerSet(nums, start+1, result, accumulator);
        accumulator.removeLast();
        powerSet(nums, start+1, result, accumulator);
    }
}