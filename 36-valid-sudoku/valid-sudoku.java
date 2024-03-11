class Solution {
    private final int SIZE = 9; // it's 9 + 1 to account for 0s to 9. we'll ignore zero

    public boolean isValidSudoku(char[][] board) {
        int[][] rowFlags = new int[SIZE][SIZE];
        int[][] colFlags = new int[SIZE][SIZE];
        int[][] boxFlags = new int[SIZE][SIZE];
        
        for(int row = 0; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                if(board[row][col] != '.'){
                    int val = board[row][col] - '1';
                    
                    if(rowFlags[row][val] > 0) return false;
                    rowFlags[row][val]++;
                    if(colFlags[col][val] > 0) return false;
                    colFlags[col][val]++;
                    int boxNum = (row /3) * 3 + (col/3);
                    if(boxFlags[boxNum][val] > 0) return false;
                    boxFlags[boxNum][val]++;
                }
            }
        }
        return true;
    }
}