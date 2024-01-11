class Solution {
    public int removeStones(int[][] stones) {
        Map<Integer, List<int[]>> mapX = new HashMap<>();
        Map<Integer, List<int[]>> mapY = new HashMap<>();

        for(int[] stone: stones){
            List<int[]> xList = mapX.getOrDefault(stone[0], new ArrayList<>());
            xList.add(stone);
            mapX.put(stone[0], xList);

            List<int[]> yList = mapY.getOrDefault(stone[1], new ArrayList<>());
            yList.add(stone);
            mapY.put(stone[1], yList);
        }

        Set<int[]> visited = new HashSet<>();

        int numOfIslands = 0;

        for(int[] stone: stones){
            if(!visited.contains(stone)){
                numOfIslands++;
                dfs(mapX, mapY, stone, visited);
            }
        }

        return stones.length - numOfIslands;
    }

    private void dfs(Map<Integer, List<int[]>> mapX,  Map<Integer, List<int[]>> mapY, int[] stone, Set<int[]> visited){
        if(visited.contains(stone)){
            return;
        }

        visited.add(stone);

        for(int[] sameRowStone: mapX.get(stone[0])){
            dfs(mapX, mapY, sameRowStone, visited);
        }

        for(int[] sameColStone: mapY.get(stone[1])){
            dfs(mapX, mapY, sameColStone, visited);
        }
    }
}