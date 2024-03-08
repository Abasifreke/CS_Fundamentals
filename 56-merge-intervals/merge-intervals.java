class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];

            return a[0] - b[0];
        });

        for(int[] interval: intervals){
            pq.offer(interval);
        }

        List<int[]> resultList = new LinkedList<>();
        resultList.add(pq.poll());

        while(!pq.isEmpty()){
            int[] next = pq.poll();

            if(resultList.getLast()[1] >= next[0]){
                resultList.getLast()[1] = Math.max(resultList.getLast()[1], next[1]);
            }else{
                resultList.add(next);
            }
        }

        int[][] result = new int[resultList.size()][2];

        result = resultList.toArray(new int[0][0]);

        return result;
    }
}