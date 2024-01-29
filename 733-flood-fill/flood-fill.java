
class Solution {
    int origColor = 0;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image[sr][sc] == color) return image;

        origColor = image[sr][sc];
        DFS(image, sr, sc, color);
        return image;
    }

    private void DFS(int[][] image, int i, int j, int color){
        
        int rows = image.length, cols = image[0].length;

        if(i < 0 || i == rows || j < 0 || j == cols || image[i][j] != origColor) return;

        image[i][j] = color;
        DFS(image, i + 1, j, color);
        DFS(image, i - 1, j, color);
        DFS(image, i, j + 1, color);
        DFS(image, i, j - 1, color);
    }
}