class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        /*
            0.... numCourses

            courses without prereq = q = {}
            course to prereq() = <int , hashset<int>>

            add all courses without prereque
            while(!q.isEmpty){
               remove current course from all lists that have it. 
                 if list becomes emput, add to queue.
                 add to visited set. 

                 if(visit contains a current course, means there's a ycle return false.')
            }
        */

        Map<Integer, HashSet<Integer>> courseToPre = new HashMap<>();
        
        for(int[] combo: prerequisites){
            int course = combo[0];
            int pre = combo[1];

            courseToPre.computeIfAbsent(course, k-> new HashSet<>()).add(pre);
        }

        LinkedList<Integer> q = new LinkedList<>();
        int coursesTaken = 0;

        for(int i = 0; i < n; i++){
            if(!courseToPre.containsKey(i)){
                q.offer(i);
            }
        }
            
        while(!q.isEmpty()){
            int course = q.poll();
            if(++coursesTaken > n) return false;

            Iterator<Map.Entry<Integer, HashSet<Integer>>> iterator = courseToPre.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<Integer, HashSet<Integer>> entry = iterator.next();
                int key = entry.getKey();

                if(entry.getValue().contains(course)){
                    courseToPre.get(key).remove(course);

                    if(courseToPre.get(key).size() == 0){
                        q.add(key);
                    }
                }
            }

        }

        return coursesTaken == n;
    }
}