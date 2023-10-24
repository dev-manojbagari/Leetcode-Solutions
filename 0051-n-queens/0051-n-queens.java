class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(char[] row:board)
            Arrays.fill(row,'.');
        List<List<String>> list = new ArrayList<>();
        
        solveNQueens(0,board,n,list);
        
        return list;
    }
    
    void solveNQueens(int curRow,char[][] board,int n,List<List<String>> list){
            
        if(curRow==n){
            constructResult(board,list);
            return;
        }
            
        for(int curCol=0;curCol<n;curCol++){
                board[curRow][curCol]='Q';
                if(isVaild(curRow,curCol,board,n))
                    solveNQueens(curRow+1,board,n,list);
                board[curRow][curCol]='.';
            
        }
    }
    
    boolean isVaild(int curRow,int curCol,char[][] board,int n){
        
        for(int row=curRow-1,col=curCol+1;row>=0&&col<n;row--,col++){
            if(board[row][col]=='Q')
                return false;
        }
        
        for(int row=curRow-1,col=curCol-1;row>=0&&col>=0;row--,col--){
            if(board[row][col]=='Q')
                return false;
        }
        
        for(int row=curRow-1;row>=0;row--){
            if(board[row][curCol]=='Q')
                return false;
        }
        
        return true;
    }
    
    void constructResult(char[][] board,List<List<String>> list){
        List<String> tempList = new ArrayList<>();
        for(char[] row:board)
            tempList.add(new String(row));
        
        list.add(tempList);
    }
}