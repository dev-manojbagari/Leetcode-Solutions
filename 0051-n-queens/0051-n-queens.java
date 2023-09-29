class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> list = new ArrayList<>();
        
        for(char[] row:board){
            Arrays.fill(row,'.');
        }
        
        solve(0,n,board,list);

        return list;
    }
    
    void solve(int curRow,int n,char[][] board,List<List<String>> res){
        
        if(curRow==n){
            res.add(construct(board));
            return;
        }
        
        for(int curCol=0;curCol<n;curCol++){
            if(isBoardVaild(board,curRow,curCol)){
                board[curRow][curCol]='Q';
                solve(curRow+1,n,board,res);
                board[curRow][curCol]='.';
            }
        }
    }
    
    boolean isBoardVaild(char[][] board,int curRow,int curCol){
        
        for(int row = 0;row<curRow;row++){
            if(board[row][curCol]=='Q')
                return false;
        }

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