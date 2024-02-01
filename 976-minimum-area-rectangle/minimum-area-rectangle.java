class Solution {
     public static int minAreaRect(int[][] points) {
        Set<String> pointSet = new HashSet<>();
        for (int[] point : points) {
            String encodedPoint = encode(point[0], point[1]);
            pointSet.add(encodedPoint);
        }

        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                if (p1[0] != p2[0] && p1[1] != p2[1]) {
                    if (pointSet.contains(encode(p1[0], p2[1])) && pointSet.contains(encode(p2[0], p1[1]))) {
                        int area = Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]);
                        minArea = Math.min(minArea, area);
                    }
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

    private static String encode(int x, int y) {
        return x + "," + y;
    }

}