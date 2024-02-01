class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> mapX = new HashMap<>();
        for (int[] p : points) {
            mapX.computeIfAbsent(p[0], k -> new HashSet<>()).add(p[1]);
        }
        int ans = Integer.MAX_VALUE;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) continue;
                int x1 = p1[0], y1 = p1[1], x2 = p2[0], y2 = p2[1];
                int area =  Math.abs(x1-x2) * Math.abs(y1-y2);
                if (area < ans && mapX.get(x1).contains(y2) && mapX.get(x2).contains(y1)) {
                    ans = area;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}