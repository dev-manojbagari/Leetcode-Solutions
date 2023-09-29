class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(board,0,0);
    }
    
    boolean solveSudoku(char[][] board,int row,int col){
        for(int i=row;i<9;i++,col=0){
            for(int j=col;j<9;j++){
                if(board[i][j]=='.'){
                    for(char num='1';num<='9';num++){
                        if(isVaild(i,j,board,num)){
                            board[i][j]=num;
                            if(solveSudoku(board,i,j+1))
                                return true;
                            board[i][j]='.';
                        }                        
                    }            
                    return false;
                }
                
            }
        }
        return true;
    }
    
    boolean isVaild(int row,int col,char[][] board,int num){
        int blockRow = (row/3)*3,blockCol=(col/3)*3;
        for(int i=0;i<9;i++){
            if(board[row][i]==num||board[i][col]==num||board[blockRow+i/3][blockCol+i%3]==num){
                return false;
            }
        }
        return true;
    }
    
    
    
}