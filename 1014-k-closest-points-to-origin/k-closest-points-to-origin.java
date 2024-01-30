class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap  = new PriorityQueue<>((a, b) -> Double.compare(distance(a[0], 0, a[1], 0), distance(b[0], 0, b[1], 0)));

        for(int[] point: points){
            minHeap.offer(point);
        }

        int[][] result = new int[k][2];

        for(int i = 0; i < k; i++){
            result[i] = minHeap.poll();
        }

        return result;
    }

    private double distance(int x1, int x2, int y1, int y2){
        // System.out.println("Distance for (" + x1 + ", " + x2 + ") is " + Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1-y2), 2)));
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1-y2), 2));
    }
}