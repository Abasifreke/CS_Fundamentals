class Solution {
    int n = 3;
    int N = n * n;
    int[][] rows = new int[N][N+1];
    int[][] cols = new int[N][N+1];
    int[][] boxes = new int[N][N+1];
    char[][] board;
    boolean solved = false;

    public void solveSudoku(char[][] board) {
        this.board = board;
        // populate state
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    int box_id = (i/n) * n + (j/n);
                    rows[i][num] = 1;
                    cols[j][num] = 1;
                    boxes[box_id][num] = 1;
                }
            }
        }
        backtrack(0,0);
    }

    private boolean isTokenValid(int r, int c, int token){
        int box_id = (r/n) * n + (c/n);
        return rows[r][token] + cols[c][token] + boxes[box_id][token] == 0;
    }

    private void backtrack(int i, int j){
        if(solved) return;

        if(i == 9) {
            solved = true;
            return;
        }

        int newI = i + ((j+1)/9);
        int newJ = (j + 1) %9;

        if(board[i][j] != '.'){
            backtrack(newI, newJ);
        }else{
            for(int c = 1; c <= 9; c++){
                if(isTokenValid(i, j, c)){
                    rows[i][c] = 1;
                    cols[j][c] = 1;
                    int box_id = (i/n) * n + (j/n);
                    boxes[box_id][c] = 1;
                    board[i][j] =(char)(c + '0');;
                    backtrack(newI, newJ);

                    if(!solved){
                        rows[i][c] = 0;
                        cols[j][c] = 0;
                        boxes[box_id][c] = 0;
                        board[i][j] = '.';
                    }
                }
            }
        }
    }
}