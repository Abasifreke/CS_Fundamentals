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
        
        if(remainder.isEmpty()){
            result.add(new ArrayList<>(accumulator));
        }

        for(int choice: remainder){
            Set<Integer> newRemainder = new HashSet<>(remainder);
            newRemainder.remove(choice);
            accumulator.add(choice);
            permRecur(newRemainder, result, accumulator);
            accumulator.removeLast();
        }
    }
}