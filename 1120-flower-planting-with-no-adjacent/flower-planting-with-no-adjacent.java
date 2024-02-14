class Solution {
    final int FLOWER_TYPES = 4;
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        // create graph
        for(int[] path: paths){
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }

        // start from 
        int[] planted = new int[n+1];
        backtrack(graph, 1, planted);
        // System.out.println(Arrays.toString(planted));
        return Arrays.copyOfRange(planted, 1, n+1);
    }

    private boolean backtrack(List<List<Integer>> graph, int i, int[] planted){
        if(i == planted.length) return true;

        for(int flower = 1; flower <= FLOWER_TYPES; flower++){
            if(isSafe(graph, flower, planted, i)){
                planted[i] = flower;
                if(backtrack(graph, i+1, planted)) return true;
                planted[i] = 0;
            }
        }

        return false;
    }

    private boolean isSafe(List<List<Integer>> graph, int flower, int[] planted, int gNum){
        for(int neighbor: graph.get(gNum)){
            if(planted[neighbor] == flower) return false;
        }
        return true;
    }
}

