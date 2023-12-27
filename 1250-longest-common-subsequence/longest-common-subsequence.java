class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m][n];

        for(int[] i: dp){
            Arrays.fill(i, -1);
        }

        return calcCommonSub(dp, text1, text2, m-1, n-1);
        // return dp[m-1][n-1];
    }

    private int calcCommonSub(int[][] dp, String text1, String text2, int m, int n){
         if (m < 0 || n < 0) {
            return 0;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if(text1.charAt(m) == text2.charAt(n)){
            dp[m][n] = calcCommonSub(dp, text1, text2, m-1, n-1) + 1;
        }else{
            int max = Math.max(calcCommonSub(dp, text1, text2, m, n-1), 
            calcCommonSub(dp, text1, text2, m-1, n));
            // max = Math.max(max, calcCommonSub(dp, text1, text2, m-1, n-1));
            dp[m][n] = max;
        }

        return dp[m][n];
    }
}