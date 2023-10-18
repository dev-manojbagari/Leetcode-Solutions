class Solution {
    int live=2,dead=3;
    public void gameOfLife(int[][] board) {
        int rows=board.length,cols=board[0].length;
        int[][] dirs ={{1,0},{0,1},{-1,0},{0,-1},{-1,1},{1,-1},{1,1},{-1,-1}};
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int aliveNeighbors = countNeighbors(i,j,board,dirs);
                
                if(board[i][j]==1){
                    if(aliveNeighbors<2||aliveNeighbors>3){
                        board[i][j]=dead;
                    }
                }else if(board[i][j]==0){
                    if(aliveNeighbors==3){
                        board[i][j]=live;
                    }
                }
            }
        }
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]==live)
                    board[i][j]=1;
                else if(board[i][j]==dead)
                    board[i][j]=0;
            }
        }
    }
    
    int countNeighbors(int i,int j,int[][] board,int[][] dirs){
        int count=0;
        for(int[] dir:dirs){
            int x =i+dir[0];
            int y =j+dir[1];
            
            if(x<0||x>=board.length||y<0||y>=board[0].length)
                continue;
            if(board[x][y]==1||board[x][y]==dead)
                count++;
        }        
        
        return count;        
        
    }
}