class Solution {

   
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> coursePreRequ = new HashMap<>();

        for(int[] prereq: prerequisites){
            int course = prereq[0];
            int pre = prereq[1];
            coursePreRequ.computeIfAbsent(course, k-> new ArrayList<>()).add(pre);
        }


        for(int i = 0; i < numCourses; i++){
            if(!canTakeCourse(i, coursePreRequ, new HashSet<>())){
                return false;
            }
        }

        return true;
    }

    public boolean canTakeCourse(int k, Map<Integer, List<Integer>> coursePreRequ, HashSet<Integer> visited){
        if(visited.contains(k)){
            return false;
        }

        if(!coursePreRequ.containsKey(k)){
            coursePreRequ.remove(k);
            return true;
        }

        visited.add(k);
        for(int n: coursePreRequ.get(k)){
            if(!canTakeCourse(n, coursePreRequ, visited)){
                return false;
            }
        }

        visited.remove(k);
        coursePreRequ.remove(k);
        return true;
    }
       
}