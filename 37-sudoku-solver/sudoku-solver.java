class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }

   private boolean solve(char[][] board) {
    // your code goes here
    int row = 0, col = 0;
    while(row < 9 && col < 9){
      // iterate through row and check for empty spot. When found, put 
      
      if(board[row][col] == '.'){
        for(char choice = '1'; choice <= '9'; choice++){
          if(isValid(board, row, col, choice)){
            board[row][col] = choice;
            if(solve(board)){
              return true;
            }else{
              board[row][col] = '.';
            }
          }
        }
        return false;
      }

      col++;

      if(col == 9){
        row++;
        col = 0;
      }
    }
    return true;
  }
   public boolean solve1(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell
                            
                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    
                    return false;
                }
            }
        }
        return true;
    }
  

  
  private boolean isValid(char[][] board, int row, int col, char c){
       for(int i = 0; i < 9; i++){
          if(board[row][i] == c) return false;
          if(board[i][col] == c) return false;
          int cRow = (3 * (row/3)) + i%3;
          int cCol = (3 * (col/3)) + i/3;
          if(board[cRow][cCol] == c) return false; //check 3*3 block
       }
    return true;
  }
  
}