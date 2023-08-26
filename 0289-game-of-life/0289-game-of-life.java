class Solution {
    int live = 2,dead=3;
    public void gameOfLife(int[][] board) {
        boolean vis[][] = new boolean[board.length][board[0].length];
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int count =countNeighbour(i,j,board,vis,dirs);
                
                if(board[i][j]==0){
                    if(count==3)
                        board[i][j]=live;
                }else if(board[i][j]==1){
                    if(count<2||count>3)
                        board[i][j]=dead;
                }
            }
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==dead)
                    board[i][j]=0;
                else if(board[i][j]==live)
                    board[i][j]=1;
            }
        }
    }
    
    int countNeighbour(int i,int j,int[][] board,boolean[][] vis,int[][] dirs){
           int count =0;        
           for(int[] dir:dirs){
               int x = i+dir[0];
               int y = j+dir[1];
               
               if(x<0||x>=board.length||y<0||y>=board[0].length)
                    continue; 
                   
                if(board[x][y]==1||board[x][y]==dead)
                    count++;
           }         
        
        return count;        
    }
}