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
        Set<Integer> visited = new HashSet<>();
        int coursesTaken = 0;

        for(int i = 0; i < n; i++){
            if(!courseToPre.containsKey(i)){
                q.offer(i);
            }
        }
                // System.out.println(courseToPre);
                // System.out.println(q);

        while(!q.isEmpty()){
            int course = q.poll();
            // System.out.println(coursesTaken);
            if(++coursesTaken > n) return false;

            for(int key: courseToPre.keySet()){
                if(!visited.contains(key) && courseToPre.get(key).contains(course)){
                    courseToPre.get(key).remove(course);

                    if(courseToPre.get(key).size() == 0){
                        visited.add(key);
                        q.add(key);
                    }
                }
            }

        }

        return coursesTaken == n;
    }
}