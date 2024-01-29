class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        /*
            ---- ------ --- -------------
                                        ----------
                                            ----
                                
                          --------------------

        */

        List<int[]> groups = new ArrayList<>();
        for(int[] slot: intervals){
            if(slot[1] < newInterval[0]){
                groups.add(slot);
            }

            else if(newInterval[1] < slot[0]){
                groups.add(newInterval);
                newInterval = slot;
            }else{
                newInterval[0] = Math.min(newInterval[0], slot[0]);
                newInterval[1] = Math.max(newInterval[1], slot[1]);
            }
        }
        groups.add(newInterval);

        int[][] result = new int[groups.size()][2];
        for(int j = 0; j < result.length; j++){
            result[j] = groups.get(j);
        }

        return result;
        
    }
}