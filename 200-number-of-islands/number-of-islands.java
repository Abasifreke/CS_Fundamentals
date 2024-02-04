class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        int counter = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    DFS(grid, i, j);
                    counter++;
                }
            }
        }

        return counter;
    }

    private void DFS(char[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || i == m || j < 0 || j == n || grid[i][j] != '1') return;

        grid[i][j] = '2';

        DFS(grid, i + 1, j);
        DFS(grid, i - 1, j);
        DFS(grid, i, j-1);
        DFS(grid, i, j+1);
    }
}