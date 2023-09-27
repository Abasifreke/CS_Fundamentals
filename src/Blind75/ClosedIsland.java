package Blind75;

import java.util.Arrays;

public class ClosedIsland {

    public static int numOfClosedIslands(int[][] grid) {
        int numberOfClosedIslands = 0;

        int rows = grid.length - 1, cols = grid[0].length - 1;

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (grid[i][j] == 0) {
                    numberOfClosedIslands += dfs(grid, i, j);
                    System.out.println(Arrays.deepToString(grid));
                }
            }
        }

        return numberOfClosedIslands;
    }

    private static int dfs(int[][] grid, int i, int j) {
        int rows = grid.length, cols = grid[0].length;

        if (i == rows || i < 0 || j < 0 || j == cols) {
            return 0;
        }

        if (grid[i][j] > 0) {
            return 1;
        }

        grid[i][j] = 2;
        return Math.min(dfs(grid, i, j + 1),
                Math.min(dfs(grid, i + 1, j),
                        Math.min(dfs(grid, i, j - 1), dfs(grid, i - 1, j))));

    }

    public static void main(String[] args) {
        int[][] input = {
                { 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0, 1, 1, 0 },
                { 1, 0, 1, 0, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 0 } };

        int[][] input2 = {
                { 0, 1, 1, 1, 0 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 0 } };

        System.out.println(numOfClosedIslands(input));
        System.out.println(numOfClosedIslands(input2));
    }
}
