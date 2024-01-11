class Solution {
    public int removeStones(int[][] stones) {
        if (stones.length ==0 || stones[0].length ==0) return 0;
        Map<Integer, List<int[]>> mapX = new HashMap<>();
        Map<Integer, List<int[]>> mapY = new HashMap<>();
        
        // building map of all stone on same row/col
        for(int[] stone : stones) {
            List<int[]> xList = mapX.getOrDefault(stone[0], new ArrayList<>());
            xList.add(stone);
            mapX.put(stone[0], xList);
            
            List<int[]> yList = mapY.getOrDefault(stone[1], new ArrayList<>());
            yList.add(stone);
            mapY.put(stone[1], yList);
        }
        
        Set<int[]> visited = new HashSet<>();
        
        int numComp = 0;
        for(int[] stone : stones) {
            if(!visited.contains(stone)) {
                numComp++;
                dfs(mapX,mapY, stone, visited);
            }
        }
        return stones.length - numComp;
    }
    
    private void dfs(Map<Integer, List<int[]>> mapX,
                     Map<Integer, List<int[]>> mapY,
                     int[] stone,
                     Set<int[]> visited) {
        visited.add(stone);
        for(int[] s : mapX.get(stone[0])) 
            if(!visited.contains(s)) dfs(mapX, mapY, s, visited);
        
        for(int[] s : mapY.get(stone[1])) 
            if(!visited.contains(s)) dfs(mapX, mapY, s, visited);
    }
}