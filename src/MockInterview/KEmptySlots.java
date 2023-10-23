class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, HashSet<Integer>> prereqToCourse = new HashMap<>();
        Map<Integer, HashSet<Integer>> courseToPrereq = new HashMap<>();

        for (int[] preToCourse : relations) {
            int pre = preToCourse[0];
            int course = preToCourse[1];
            prereqToCourse.computeIfAbsent(pre, k -> new HashSet<Integer>()).add(course);
            courseToPrereq.computeIfAbsent(course, k -> new HashSet<Integer>()).add(pre);
        }

        LinkedList<Integer> q = new LinkedList<>();
        Set<Integer> completed = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            if (!courseToPrereq.containsKey(i))
                q.offer(i);
        }

        int numOfSemesters = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size > 0) {
                int courseNum = q.offer();
                completed.add(courseNum);

                for (int i : prereqToCourse.get(courseNum)) {
                    courseToPrereq.get(i).remove(courseNum);

                    if (courseToPrereq.get(i).size() == 0) {
                        q.offer();
                    }
                }

                size--;
            }
            numOfSemesters++;

        }

        if (completed.size() < n) {
            return -1;
        }
        return numOfSemesters;

    }
}
