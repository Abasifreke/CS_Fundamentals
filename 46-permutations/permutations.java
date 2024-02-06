class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();
        for(int i: nums){
            numSet.add(i);
        }

        // for(int i = 0; i < nums.length; i++){
            permRecur(numSet, result, new ArrayList<>());
        // }

        return result;
    }

    private void permRecur(Set<Integer> remainder, List<List<Integer>> result, List<Integer> accumulator){
        
        if(accumulator.size() == remainder.size()){
            result.add(new ArrayList<>(accumulator));
        }

        for(int choice: remainder){
            if(!accumulator.contains(choice)){
                accumulator.add(choice);
                permRecur(remainder, result, accumulator);
                accumulator.removeLast();
            }
        }
    }
}