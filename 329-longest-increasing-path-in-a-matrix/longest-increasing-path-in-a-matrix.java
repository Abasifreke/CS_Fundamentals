class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];

        int longestPath = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                longestPath = Math.max(longestPath, recordLongestPath(matrix, i, j, -1, memo));
            }
        }
        
        return longestPath;
    }
    
    private int recordLongestPath(int[][] matrix, int i, int j, int prev, int[][] memo){
         int m = matrix.length, n = matrix[0].length;
        
        if(i < 0 || i == m || j < 0 || j == n || matrix[i][j] <= prev){
            return -1;
        }

        if(memo[i][j] != 0){
           return memo[i][j];
        }
        
        memo[i][j] = Math.max(memo[i][j], recordLongestPath(matrix, i+1, j, matrix[i][j],memo));
        memo[i][j] = Math.max(memo[i][j], recordLongestPath(matrix, i-1, j, matrix[i][j],memo));
        memo[i][j] = Math.max(memo[i][j], recordLongestPath(matrix, i, j+1, matrix[i][j],memo));
        memo[i][j] = Math.max(memo[i][j], recordLongestPath(matrix, i, j-1, matrix[i][j],memo));
        return ++memo[i][j]; 
    }
}