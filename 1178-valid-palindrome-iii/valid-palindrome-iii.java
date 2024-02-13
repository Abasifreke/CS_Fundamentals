class Solution {

    public boolean isValidPalindrome(String s, int k) {
        Integer[][] memo = new Integer[s.length()][s.length()];
        return canStringBePalindrome(s, 0, s.length() - 1, memo) <= k;
    }

    private int canStringBePalindrome(String s, int start, int end,  Integer[][] memo  ) {

        if (s.length() <= 1 || start == end) {
            return 0;
        }

        if(memo[start][end] != null){
            return memo[start][end];
        }

        if(start == end-1)
            return s.charAt(start) != s.charAt(end) ? 1:0;

        if(s.charAt(start) == s.charAt(end)){
             memo[start][end] = canStringBePalindrome(s,start+1,end-1,memo); 
             return memo[start][end];
        }
    
   
        memo[start][end] =  1+ Math.min(
            canStringBePalindrome(s,start,end-1,memo), 
            canStringBePalindrome(s,start +1,end,memo));
    
        return memo[start][end];
    }

   
}