class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        int[][] memo = new int[m + 1][n + 1];

        for(int[] a: memo){
            Arrays.fill(a, -1);
        }
        
        return deleteDistance(word1, word2, m, n, memo);
    }

    private int deleteDistance(String w1, String w2, int i, int j, int[][] memo){
        if(i == 0){
            return j;
        }

        if(j == 0){
            return i;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        if(w1.charAt(i-1) == w2.charAt(j-1)){
            memo[i][j] = deleteDistance(w1, w2, i-1, j-1, memo);
        }else{
            memo[i][j] = Math.min(deleteDistance(w1, w2, i-1, j, memo), deleteDistance(w1, w2, i, j-1, memo)) + 1;
        }

        return memo[i][j];
    }
}