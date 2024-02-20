class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] memo = new int[m][n];

        for(int[] a : memo){
            Arrays.fill(a, -1);
        }

        return editDistance(word1, word2, m-1, n-1, memo);

    }

    private int editDistance(String w1, String w2, int i, int j, int[][] memo){
        if(i < 0){
            return j + 1;
        }

        if(j < 0){
            return i + 1;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        if(w1.charAt(i) == w2.charAt(j)){
            memo[i][j] = editDistance(w1, w2, i-1, j-1, memo);
        }else{
            memo[i][j] = Math.min(editDistance(w1, w2, i-1, j, memo), editDistance(w1, w2, i, j-1, memo)) ;
            memo[i][j] = Math.min(memo[i][j], editDistance(w1, w2, i-1, j-1, memo))  + 1;
        }   

        return memo[i][j];
    }
}