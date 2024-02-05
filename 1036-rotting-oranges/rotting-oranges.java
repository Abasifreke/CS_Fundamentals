class Solution {
    public int orangesRotting(int[][] grid) {
        /*
            [
            [2,1,1],
            [1,1,1],
            [0,1,2]
            ]
        */

        int m = grid.length, n = grid[0].length;
        int globalMax = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int[] min = {Integer.MAX_VALUE};
                    DFS(grid, i, j, min, 0);
                    if(min[0] == Integer.MAX_VALUE){
                        System.out.println("return -1 for i and j : " + i + " " + j); 
                        System.out.println(Arrays.deepToString(grid));
                        return -1;
                    }
                    globalMax = Math.max(globalMax, min[0]);
                }
            }
        }

        return Math.max(globalMax, 0);
    }

    private void DFS(int[][] grid, int i, int j, int[] min, int acc){
        int m = grid.length, n = grid[0].length;

        if(i < 0 || i == m || j < 0 || j == n || grid[i][j] == 0) return;

        if(grid[i][j] == 2){
            min[0] = Math.min(min[0], acc);
            return;
        }

        int orig = 1;
        grid[i][j] = 0;

        DFS(grid, i+1, j, min, acc + 1);
        DFS(grid, i-1, j, min, acc + 1);
        DFS(grid, i, j+1, min, acc + 1);
        DFS(grid, i, j-1, min, acc + 1);
        
        grid[i][j] = orig;
    }
    
}