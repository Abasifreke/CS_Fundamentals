class Solution {
    public int maxDepth(String s) {
        int openCount = 0;
        int  maxCount = 0;

        for(char c: s.toCharArray()){

            if(c == '('){
                maxCount = Math.max(maxCount, ++openCount);
            }else if(c == ')'){
                openCount--;
            }
        }

        return maxCount;
    }
}