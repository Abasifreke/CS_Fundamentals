class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int[] inDegree = new int[n];
        List<List<Integer>> preToCourses = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            preToCourses.add(new ArrayList<>());
        }

        for(int[] combo: prerequisites){
            int course = combo[0];
            int pre = combo[1];

            preToCourses.get(pre).add(course);
            inDegree[course]++;
        }

        LinkedList<Integer> q = new LinkedList<>();
        int coursesTaken = 0;

        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
            
        while(!q.isEmpty()){
            int pre = q.poll();
            if(++coursesTaken > n) return false;

            for(int course: preToCourses.get(pre)){
                inDegree[course]--;
                
                if(inDegree[course] == 0){
                    q.add(course);
                }
            }
            

        }

        return coursesTaken == n;
    }
}