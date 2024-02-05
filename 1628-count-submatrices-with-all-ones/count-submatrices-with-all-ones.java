class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] precompute = new int[m][n];

        // precompute
         for(int i = 0; i < m; i++){
             
            int count = 0;
            for(int j = n-1; j >= 0; j--){
                if(mat[i][j] == 1){
                    precompute[i][j] = ++count;
                }else {
                    count = 0;
                }
            }
         }

        int acc = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int min = Integer.MAX_VALUE;

                for(int k = i; k < m; k++){
                    min = Math.min(min, precompute[k][j]);
                    acc += min;
                }
            }
        }

        return acc;

    }
}