class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        
        for(char[] row:board)
            Arrays.fill(row,'.');
        
        List<List<String>> list = new ArrayList<>();
        
        solveNQueens(0,board,list);
        
        return list;
    }
    
    void solveNQueens(int curRow,char[][] board,List<List<String>> list){
        if(curRow==board.length){
            constructResult(board,list);
            return;
        }        
        
        for(int curCol=0;curCol<board.length;curCol++){
            board[curRow][curCol]='Q';
            if(isVaild(board,curRow,curCol))
                solveNQueens(curRow+1,board,list);
            board[curRow][curCol]='.';
        }            
    }
    
    void constructResult(char[][] board,List<List<String>> list){
        List<String> tempList= new ArrayList<>();
        
        for(char[] row:board)
            tempList.add(new String(row));
        
        list.add(tempList);        
    }

    boolean isVaild(char[][] board,int curRow,int curCol){
            
        for(int row=0;row<curRow;row++)
            if(board[row][curCol]=='Q')
                return false;
        int row=0,col=0;
        for(row=curRow-1,col=curCol+1;row>=0&&col<board.length;row--,col++){
            if(board[row][col]=='Q')
                return false;
        }
        
        for(row=curRow-1,col=curCol-1;row>=0&&col>=0;row--,col--){
            if(board[row][col]=='Q')
                return false;
        }
        
        
        return true;
    }
}