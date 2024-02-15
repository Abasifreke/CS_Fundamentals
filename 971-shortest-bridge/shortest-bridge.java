class Solution {

    class CellOfIsland {
        int row;
        int col;
        int islandId;

        CellOfIsland(int row, int col, int id){
            this.row = row;
            this.col = col;
            this.islandId = id;
        }
    }

    public int shortestBridge(int[][] grid) {
       List<CellOfIsland> islandCells = new ArrayList<>();
       int islandCount = createIslands(grid, islandCells);
    //    System.out.println(Arrays.deepToString(grid));
    //    System.out.println(islandCells);
       Map<Integer, Map<Integer, Integer>> distanceGraph = new HashMap<>();
       calculateGraph(islandCells, distanceGraph, islandCount);
       return distanceGraph.get(2).get(3);
    }

    private int createIslands(int[][] grid, List<CellOfIsland> islandCells){
        int islandCount = 0, ROWS = grid.length, COLS = grid[0].length;
        

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 1){
                    // island numbering would start from 2 for first island since 1 is taken
                    islandCount = islandCount == 0 ? 2 : islandCount + 1;
                    DFS(grid, i, j, islandCount, islandCells);
                }
            }
        }

        return islandCount > 0 ? islandCount -1 : 0;
    }

    private void DFS(int[][] grid, int rowIndx, int colIndx, int replacement, List<CellOfIsland> islandCells){
        int ROWS = grid.length, COLS = grid[0].length;
        if(rowIndx < 0 || colIndx < 0 || rowIndx == ROWS || colIndx == COLS || grid[rowIndx][colIndx] != 1)
            return;
        
        grid[rowIndx][colIndx] = replacement;
        islandCells.add(new CellOfIsland(rowIndx, colIndx, replacement));
        DFS(grid, rowIndx + 1, colIndx, replacement, islandCells);
        DFS(grid, rowIndx - 1, colIndx, replacement, islandCells);
        DFS(grid, rowIndx, colIndx + 1, replacement, islandCells);
        DFS(grid, rowIndx, colIndx - 1, replacement, islandCells);
    }

    // get number of cells in this case between cells. 
    private int getDistance(int sRow, int sCol, int eRow, int eCol){
        return Math.abs(sRow - eRow) + Math.abs(sCol - eCol) -1;
    }

    private void calculateGraph(List<CellOfIsland> islandCells, 
    Map<Integer, Map<Integer, Integer>> distanceGraph, 
    int islandCount){
        
        for(int i = 2; i < islandCount + 2; i++){
            distanceGraph.put(i, new HashMap<>());
            for(int j = 2; j < islandCount + 2; j++){
                if(i != j){
                    distanceGraph.get(i).put(j, Integer.MAX_VALUE);
                }
            }
        }

        // System.out.println(distanceGraph);

        for(int i = 0; i < islandCells.size(); i++){
            for(int j = i+1; j < islandCells.size(); j++){
                CellOfIsland a = islandCells.get(i);
                CellOfIsland b = islandCells.get(j);
                if(a.islandId == b.islandId)
                    continue;
                int distance = getDistance(a.row, a.col, b.row, b.col);
                // update graph
                distanceGraph.get(a.islandId).put(b.islandId, Math.min(distanceGraph.get(a.islandId).get(b.islandId), distance));
                // distanceGraph.get(b.islandId).put(a.islandId, Math.min(distanceGraph.get(b.islandId).get(a.islandId), distance));
            }
        }

                // System.out.println(distanceGraph);

    }
}