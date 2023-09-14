class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
       
        for(char[] row:board)
            Arrays.fill(row,'.');
        
        solve(res,0,n,board);
        
        return res;
    }
    
    void solve(List<List<String>> res,int curRow,int n,char[][] board){
        if(curRow==n){
           res.add(construct(board));
            return;
        }
        
        for(int curCol=0;curCol<n;curCol++){
            if(check(curRow,curCol,board,n)){
                board[curRow][curCol]='Q';
                solve(res,curRow+1,n,board);
                board[curRow][curCol]='.';
            }
        }
    }
    
    boolean check(int curRow,int curCol,char[][] board,int n){
        for(int row=0;row<curRow;row++){
            if(board[row][curCol]=='Q')
                return false;
        }
        
        for(int row=curRow-1,col=curCol+1;row>=0&&col<n;row--,col++){
            if(board[row][col]=='Q')
                return false;
        }
        
        for(int row=curRow-1,col=curCol-1;row>=0&&col>=0;row--,col--){
            if(board[row][col]=='Q')
                return false;
        }
        
        return true;
    }
    
    List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();
        for(char[] row :board)
            list.add(new String(row));
       
        return list;
    }
}