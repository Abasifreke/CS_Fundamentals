class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];

        int openCount = 0;
        int i = 0;
        for(char c: seq.toCharArray()){
            if(c == '('){
                   openCount++;
                                    res[i] = +openCount %2;

            }else{
                 res[i] = openCount %2;
                openCount--;
            }
            i++;
        }

        return res;

    }
}