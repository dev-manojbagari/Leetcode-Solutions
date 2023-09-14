class Solution {
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
    
//        for (int i = row; i < 9; i++, col = 0) { // note: must reset col here!
//             for (int j = col; j < 9; j++) {
//                 if (board[i][j] != '.') continue;
//                 for (char num = '1'; num <= '9'; num++) {
//                     if (vaild(board, i, j, num)) {
//                         board[i][j] = num;
//                         if (solve(board, i, j + 1))
//                             return true;
//                         board[i][j] = '.';
//                     }
//                 }
//                 return false;
//             }
//         }
//         return true;
    
    
    boolean solve(char[][] board,int row,int col){
        
        for(int i=row;i<9;i++,col=0){
            for(int j=col;j<9;j++){
                if(board[i][j]=='.'){
                    for(char num='1';num<='9';num++){
                        if(vaild(board,i,j,num)){
                            board[i][j]=num;
                            if(solve(board,i,j+1))
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
    
    boolean vaild(char[][] board,int row,int col,char num){
        
        int blockrow = row/3,blockcol=col/3;
        for(int i=0;i<9;i++){
            if(board[row][i]==num||board[i][col]==num||board[(3*blockrow+i/3)][3*blockcol+i%3]==num)
                return false;
        }
        
        return true;
        
    }
    
}