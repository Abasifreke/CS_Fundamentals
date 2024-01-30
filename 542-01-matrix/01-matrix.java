class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][n];
        
        /*
            0 0 0
            0 1 0
            1 1 1

            0 0 0
            0 1 0 
            1 2 1


            0 0 0
            0 1 0 
            1 2 1
            
    


        */
        for(int i = 0; i < m; i++){
            dp[i] = Arrays.copyOf(mat[i], n);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] != 0){
                    dp[i][j] = Math.min(getValOrMax(dp, i, j-1), getValOrMax(dp, i-1, j)) + 1;
                }
            }
        }

        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(dp[i][j] != 0){
                    dp[i][j] = Math.min(dp[i][j], Math.min(getValOrMax(dp, i, j+1), getValOrMax(dp, i+1, j)) + 1);
                }
            }
        }

        return dp;
    }

    private int getValOrMax(int[][] mat, int i, int j){
        int m = mat.length, n = mat[0].length;
        if(i < 0 || i == m || j < 0 || j == n) return m * n;

        return mat[i][j];
    }
}