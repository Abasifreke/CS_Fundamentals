class Solution {

    int[] unionSet;
    int[] rank;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        this.unionSet = new int[n];
        this.rank = new int[n];

        for(int i = 0; i < unionSet.length; i++){
            unionSet[i] = i;
            rank[i] = 1;
        }

        int result = n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    result -= union(i, j);
                }
            }
        }
   
        return result;
    }

    private int union( int nodeA, int nodeB){
        int rootOfA = find( nodeA);
        int rootOfB = find( nodeB);

        if(rootOfA != rootOfB){
            if(rank[rootOfA] > rank[rootOfB]){
                unionSet[rootOfB] = rootOfA;
            }else if(rank[rootOfA] < rank[rootOfB]){
                unionSet[rootOfA] = rootOfB;
            }else{
                unionSet[rootOfB] = rootOfA;
                rank[rootOfA] += 1;
            }

            return 1;
        }

        return 0;
    }

    private int find(int node){
        if(unionSet[node] == node) return node;

        return unionSet[node] = find(unionSet[node]);
    }
}