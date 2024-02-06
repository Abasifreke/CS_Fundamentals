class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permRecur(nums, result, new ArrayList<>());

        return result;
    }

    private void permRecur(int[] nums, List<List<Integer>> result, List<Integer> accumulator){
        
        if(accumulator.size() == nums.length){
            result.add(new ArrayList<>(accumulator));
            return;
        }

        for(int choice: nums){
            if(!accumulator.contains(choice)){
                accumulator.add(choice);
                permRecur(nums, result, accumulator);
                accumulator.removeLast();
            }
        }
    }
}