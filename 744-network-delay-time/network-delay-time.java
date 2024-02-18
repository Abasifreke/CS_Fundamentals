import java.util.AbstractMap.SimpleEntry;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<SimpleEntry<Integer, Integer>>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] time: times){
            int start = time[0];
            int dest = time[1];
            int weight = time[2];

            graph.get(start).add(new SimpleEntry<Integer, Integer>(dest, weight));
        };
        int[] minDistance = new int[n+1];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[0] = 0;
        minDistance[k] = 0;

        // Pair of destination to weight
        PriorityQueue<SimpleEntry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        Set<Integer> visited = new HashSet<>();
        pq.offer(new SimpleEntry<>(k, 0));

        while(!pq.isEmpty()){
            SimpleEntry<Integer, Integer> nodeWithWeight = pq.poll();
            int nodeKey = nodeWithWeight.getKey();
            int nodeWeight = nodeWithWeight.getValue();

            if(nodeWeight > minDistance[nodeKey]) continue;

            for(SimpleEntry<Integer, Integer> neighbor: graph.get(nodeKey)){
                if(minDistance[neighbor.getKey()] > neighbor.getValue() + nodeWeight){
                    minDistance[neighbor.getKey()] = neighbor.getValue() + nodeWeight;
                    pq.offer(new SimpleEntry(neighbor.getKey(), minDistance[neighbor.getKey()]));
                }
            }
        
        }

        int max = 0;
        for(int dist: minDistance){
            max = Math.max(max, dist);
        }

        return max == Integer.MAX_VALUE ? -1 : max;
        
    }
}