class Solution {
    public int earliestAcq(int[][] logs, int n) {
        // sort logs if needed.
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        HashSet<Integer> unconnected = new HashSet<>();

        for(int i = 0; i < n; i++){
            unconnected.add(i);
        }

        for(int[] log: logs){
            Integer a = log[1];
            Integer b = log[2];

            unconnected.remove(a);
            unconnected.remove(b);

            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(b);

            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(b).add(a);


            if(unconnected.isEmpty()){
                List<Integer> reachableNodes = new ArrayList<>();
                reachableFromNode(graph, 0, new HashSet<Integer>(), reachableNodes);

                if(reachableNodes.size() == n){
                    return log[0];
                }
            }
        }

        // if(!unconnected.isEmpty()){
            return -1;
        // }
    }

    private void reachableFromNode(Map<Integer, List<Integer>> graph, int i, HashSet<Integer> visited, List<Integer> reachableNodes){
        if(visited.contains(i)){
            return;
        }

        visited.add(i);
        reachableNodes.add(i);

        for(int node: graph.get(i)){
            reachableFromNode(graph, node, visited, reachableNodes);
        }
    }
}