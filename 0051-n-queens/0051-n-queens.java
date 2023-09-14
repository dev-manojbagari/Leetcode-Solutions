class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row:board)
            Arrays.fill(row,'.');
        
        solve(0,n,board,res);
        return res;
    }
    
    void solve(int curRow,int n,char[][] board,List<List<String>> res){
        if(curRow==n){
            res.add(construct(board));
            return;
        }        
        
        for(int curCol=0;curCol<n;curCol++){
            if(isValidPosition(curRow,curCol,board)){
                board[curRow][curCol]='Q';
                solve(curRow+1,n,board,res);
                board[curRow][curCol]='.';
            }
        }
        
    }
    boolean isValidPosition(int curRow,int curCol,char[][] board){
        
        for(int row=0;row<curRow;row++)
            if(board[row][curCol]=='Q')
                return false;
        
        for(int row=curRow-1,col=curCol+1;row>=0&&col<board.length;row--,col++){
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
        for(char[] row:board){
            list.add(new String(row));
        }
        
        return list;
    }
}