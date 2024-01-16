class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> maxIndex = new Stack<>();
        int maxArea = 0;
        maxIndex.push(-1);
        int i = 0;
        for(; i < heights.length; i++){
            while(maxIndex.peek() != -1  && heights[maxIndex.peek()] >= heights[i]){
                int currHeight = heights[maxIndex.pop()];
                int currWidth = i - maxIndex.peek() - 1;
                maxArea = Math.max(maxArea, currHeight * currWidth);
            }

            maxIndex.push(i);
        }

        while(maxIndex.peek() != -1 ){
            int currHeight = heights[maxIndex.pop()];
            int currWidth = i - maxIndex.peek() - 1;
            maxArea = Math.max(maxArea, currHeight * currWidth);
        }

        return maxArea;
    }
}