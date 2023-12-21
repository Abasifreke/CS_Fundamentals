class Solution {
    int done_count=0;
    Map<Integer,Set<Integer>> rows = new HashMap<>();
    Map<Integer,Set<Integer>> cols = new HashMap<>();
    Map<Integer,Set<Integer>> nines = new HashMap<>();
    int done = 0;
    char[][] ans;

    public void copy(char[][] ans,char[][] board)
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                ans[i][j] = board[i][j];
            }
        }
    }

    public void solve(char[][] board,int ind)
    {
        if(done == 1)
        {
            return;
        }
        if(ind == board.length)
        {
            copy(ans,board);
            done = 1;
            return;
        }
        Set<Integer> s1 = rows.getOrDefault(ind,new HashSet<>());
        for(int j=0;j<board[0].length;j++)
        {
            Set<Integer> s2 = cols.getOrDefault(j,new HashSet<>());
            Set<Integer> s3 = nines.getOrDefault(3*(ind/3)+(j/3),new HashSet<>());
            if(board[ind][j]=='.')
            { 
                for(int p=1;p<=9;p++)
                {
                    if(!s1.contains(p) && !s2.contains(p) && !s3.contains(p))
                    {
                        s1.add(p);
                        s2.add(p);
                        s3.add(p);
                        board[ind][j] = (char)(p+'0');
                        rows.put(ind,s1);
                        cols.put(j,s2);
                        nines.put(3*(ind/3)+(j/3),s3);
                        solve(board,ind);
                        s1.remove(p);
                        s2.remove(p);
                        s3.remove(p);
                        rows.put(ind,s1);
                        cols.put(j,s2);
                        nines.put(3*(ind/3)+(j/3),s3);
                        board[ind][j] = '.';
                    }
                }
                if(board[ind][j]=='.')
                {
                    return;
                }
            }
        }
        solve(board,ind+1);
    }
    public void solveSudoku(char[][] board) {
        ans = new char[board.length][board.length];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                Set<Integer> s1 = rows.getOrDefault(i,new HashSet<>());
                Set<Integer> s2 = cols.getOrDefault(j,new HashSet<>());
                Set<Integer> s3 = nines.getOrDefault(3*(i/3)+(j/3),new HashSet<>());

                if(board[i][j]!='.')
                {
                    s1.add(board[i][j]-'0');
                    s2.add(board[i][j]-'0');
                    s3.add(board[i][j]-'0');
                    rows.put(i,s1);
                    cols.put(j,s2);
                    nines.put(3*(i/3)+(j/3),s3);
                }
            }
        }
        solve(board,0);
        for(int i=0;i<ans.length;i++)
        {
            for(int j=0;j<ans.length;j++)
            {
                board[i][j] = ans[i][j];
            }
        }
    }
}