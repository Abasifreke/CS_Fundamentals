class Solution {

    public List<List<Integer>> combSums = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target, new ArrayList<>());
        return combSums;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> tempList){
        if(target < 0){
            return;
        }

        if(target == 0){
            combSums.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            tempList.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], tempList);
            tempList.removeLast();
        }
    }
}