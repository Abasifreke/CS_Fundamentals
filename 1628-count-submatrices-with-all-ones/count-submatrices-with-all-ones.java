class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] height = new int[n];

        int acc = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;   //  height of histogram;
                for (int k = j, min = height[j]; k >= 0 && min > 0; k--) {
                    min = Math.min(min, height[k]);
                    acc += min;
                }
            }
        }

        return acc;

    }
}