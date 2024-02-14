class Solution {
//     final int FLOWER_TYPES = 4;
//     public int[] gardenNoAdj(int n, int[][] paths) {
//         List<List<Integer>> graph = new ArrayList<>();

//         for(int i = 0; i <= n; i++){
//             graph.set(i, new ArrayList<>());
//         }

//         // create graph
//         for(int[] path: paths){
//             graph.get(path[0]).add(path[1]);
//             graph.get(path[1]).add(path[0]);
//         }

//         // start from 
//         int[] planted = new int[n];
//         for(int i = 1; i <= n; i++){
//             if(planted[i-1] == 0){
//                 backtrack(graph, i, planted, n);
//             }
//         }

//         return planted;
//     }

//     private boolean backtrack(List<List<Integer>> graph, int i, int[] planted, int N){
//         if(i)
//     }
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] ans = new int[N];
        HashMap<Integer, List<Integer>> edges = new HashMap<>();
        HashMap<Integer, Set<Integer>> color = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            edges.put(i, new ArrayList<>());
            color.put(i, new HashSet<>());
        }
        for(int[] p : paths) {
            edges.get(p[0]).add(p[1]);
            edges.get(p[1]).add(p[0]);
        }
        for(int i = 1; i <= N; i++) {
            int c = 1;
            while(color.get(i).contains(c)) c++;
            ans[i-1] = c;
            for(int k : edges.get(i)) color.get(k).add(c);
        }
        return ans;
    }
}

