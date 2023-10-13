class Solution {
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
    
    boolean solve(char[][] board,int row,int col){
        for(int i=row;i<board.length;i++,col=0){
            for(int j=col;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char num='1';num<='9';num++){
                        if(isVaild(board,i,j,num)){
                            board[i][j]=num;
                            if(solve(board,i,j+1)){
                                return true;
                            }
                            board[i][j]='.';
                        }
                        
                    }
                    return false;
                }
            }
        }
        
        return true;
    }
    
    boolean isVaild(char[][] board,int row,int col,char num){
        int blockRow = (row/3)*3,blockCol=(col/3)*3;
        
        for(int i=0;i<9;i++){
            if(board[row][i]==num||board[i][col]==num||board[blockRow+i/3][blockCol+i%3]==num)
                return false;
        }
        
        return true;
    }
}