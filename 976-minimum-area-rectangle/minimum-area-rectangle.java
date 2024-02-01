class Solution {
    public int minAreaRect(int[][] points) {
        int minArea = Integer.MAX_VALUE;
        int n = points.length;

        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        HashSet<String> pointSet = new HashSet<>();
        for(int[] point: points){
            pointSet.add(encode(point[0], point[1]));
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j){
                    int[] point1 = points[i];
                    int[] point2 = points[j];
                    
                    if(point1[0] == point2[0] || point1[1] == point2[1]) continue;
                    
                    if(pointSet.contains(encode(point1[0], point2[1])) && pointSet.contains(encode(point2[0], point1[1]))){
                        minArea = Math.min(minArea, area(point1, point2));
                    }
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

    private String encode(int x, int y){
        return x + "|" + y;
    }

    private int area(int[] point1, int[] point2){
        return Math.abs(point1[0]-point2[0]) * Math.abs(point1[1] - point2[1]); 
    }
}