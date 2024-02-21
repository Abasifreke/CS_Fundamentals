class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] bm) {
        int m = bm.length, n = bm[0].length;
    boolean[][] atlMap = new boolean[m][n];
    boolean[][] pacMap = new boolean[m][n];
    
    // set top and bottom row to true for pac and atl respc.
     for(int i = 0; i < n; i++){
      // pacMap[0][i] = true;
      // atlMap[m-1][i] = true;
       DFS(0, i, bm, pacMap, bm[0][i]);
       DFS(m-1, i, bm, atlMap, bm[m-1][i]);
    }
   
    // set left and right cols to true for pac and atl respc.
    for(int i = 0; i < m; i++){
       DFS(i, 0, bm, pacMap, bm[i][0]);
       DFS(i, n-1, bm, atlMap, bm[i][n-1]);
    }
    
    
    // go through island maps and create result.  
    List<List<Integer>> resultList = new ArrayList<>();
    
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if(pacMap[i][j] && atlMap[i][j]){
            List<Integer> sub = new ArrayList<>();
            sub.add(i);
            sub.add(j);
            resultList.add(sub);
        }
      }
    }
    
    return resultList;
  }
  
  private static void DFS(int r, int c, int[][] bm, boolean[][] reachable, int prev){
    int m = reachable.length, n = reachable[0].length;
    
    if(r < 0 || c < 0 || r == m || c == n || reachable[r][c] || bm[r][c] < prev) return;
    
    reachable[r][c] = true;
    
    DFS(r+1, c, bm, reachable, bm[r][c]);
    DFS(r-1, c, bm, reachable, bm[r][c]);
    DFS(r, c+1, bm, reachable, bm[r][c]);
    DFS(r, c-1, bm, reachable, bm[r][c]);
  }
  
  
}