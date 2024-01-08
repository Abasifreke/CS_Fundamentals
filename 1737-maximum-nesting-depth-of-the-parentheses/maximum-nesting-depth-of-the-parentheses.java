class Solution {
    public int maxDepth(String s) {
        int openCount = 0;
        int  maxCount = 0;

        for(char c: s.toCharArray()){
            if(c != '(' && c != ')')
                continue;

            if(c == '('){
                openCount++;
                maxCount = Math.max(maxCount, openCount);
            }else{
                openCount--;
            }
        }

        return maxCount;
    }
}