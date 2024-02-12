class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] unionSet = new int[n];
        int[] rank = new int[n];

        for(int i = 0; i < unionSet.length; i++){
            unionSet[i] = i;
            rank[i] = 1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && isConnected[i][j] == 1){
                    union(unionSet, rank, i, j);
                }
            }
        }
        // System.out.println(Arrays.toString(unionSet));
        Set<Integer> roots = new HashSet<>();
        for(int i = 0; i < n; i++){
            roots.add(find(unionSet, i));
        }

        return roots.size();
    }

    private void union(int[] unionSet, int[] rank, int nodeA, int nodeB){
        int rootOfA = find(unionSet, nodeA);
        int rootOfB = find(unionSet, nodeB);

        if(rootOfA != rootOfB){
            if(rank[rootOfA] > rank[rootOfB]){
                unionSet[rootOfB] = rootOfA;
            }else if(rank[rootOfA] < rank[rootOfB]){
                unionSet[rootOfA] = rootOfB;
            }else{
                unionSet[rootOfB] = rootOfA;
                rank[rootOfA] += 1;
            }

        }

    }

    private int find(int[] unionSet, int node){
        if(unionSet[node] == node) return node;

        unionSet[node] = find(unionSet, unionSet[node]);
        return unionSet[node];
    }
}