class Solution {
    Map<Integer, Set<Character>> row = new HashMap<>();
    Map<Integer, Set<Character>> col = new HashMap<>();
    Map<Integer, Set<Character>> box = new HashMap<>();

    public void solveSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i <= 9; i++) {
            row.putIfAbsent(i, new HashSet<Character>());
            col.putIfAbsent(i, new HashSet<Character>());
            box.putIfAbsent(i, new HashSet<Character>());
        }

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    char k = board[i][j];

                    row.putIfAbsent(i, new HashSet<Character>());
                    //if (row.get(i).contains(k)) return false;
                    row.get(i).add(k);

                    col.putIfAbsent(j, new HashSet<Character>());
                    //if (col.get(j).contains(k)) return false;
                    col.get(j).add(k);

                    int index = (i/3)*3 + j/3; // box index

                    box.putIfAbsent(index, new HashSet<Character>());
                    //if (box.get(index).contains(k)) return false;
                    box.get(index).add(k);
                } else {
                    list.add(new int[]{i, j});
                }
            }
        }

        helper(board, list, 0);
    }

    boolean helper(char[][] board, List<int[]> list, int index) {
        if(index == list.size()) return true;

        int[] a = list.get(index);
        int i = a[0];
        int j = a[1];
        int k = (i/3)*3 + j/3; // box index

        for (int q = 1; q <= 9; q++){
            char p = (char)('0' + q);

            if(!row.get(i).contains(p) && !col.get(j).contains(p) && !box.get(k).contains(p)) {
                board[i][j] = p;
                row.get(i).add(p);
                col.get(j).add(p);
                box.get(k).add(p);

                if(helper(board, list, index+1)) return true;

                board[i][j] = '.';
                row.get(i).remove(p);
                col.get(j).remove(p);
                box.get(k).remove(p);
            }       
        }
        return false;
    }
}