class Solution {
    public int deleteAndEarn(int[] nums) {
        /*
            [1,1,1,2,4,5,5,5,6]

            {1=3, 2=1, 4=1, 5=3, 6=1}
            dp1 = 3
            dp2 = 1
            dp3 = 8
        */
        TreeMap<Integer, Integer> counter = new TreeMap<>();

        for(int i: nums){
            counter.put(i, counter.computeIfAbsent(i, k-> 0) + 1);
        }

        int firstKey = counter.firstKey();
        int dp1 = firstKey * counter.get(firstKey);
        if(counter.size() == 1) return dp1;
        
        int prevKey = counter.higherKey(firstKey);
        int secondLocal = prevKey * counter.get(prevKey);
        int dp2Sub = Math.abs(firstKey - prevKey) > 1 ? secondLocal + dp1 : secondLocal;
        int dp2 = Math.max(dp1, dp2Sub);

        counter.pollFirstEntry();
        counter.pollFirstEntry();
        
        for(int key: counter.keySet()){
            int keyLocal = key * counter.get(key);
            int dp3Sub = Math.abs(key - prevKey) > 1 ? dp2 + keyLocal : keyLocal + dp1;
            int dp3 = Math.max(dp2, dp3Sub);
            dp1 = dp2;
            dp2 = dp3;
            prevKey = key;
        }

        return dp2;
    }
}