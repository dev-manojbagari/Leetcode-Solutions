class Solution {
    public void solve(char[][] board) {
        int rows=board.length,cols=board[0].length;
        boolean[][] vis= new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0||j==0||i==rows-1||j==cols-1){
                    if(board[i][j]=='O'){
                        dfs(i,j,board,vis);
                    }                    
                }
            }
        }
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O'&&vis[i][j]==false){
                    board[i][j]='X';
                }                    
            }
        }
    }
    
    
       void dfs(int i,int j,char[][] grid,boolean[][] vis){
        
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||vis[i][j]||grid[i][j]=='X')
            return;
        vis[i][j]=true;
        
        dfs(i+1,j,grid,vis);
        dfs(i,j+1,grid,vis);
        dfs(i-1,j,grid,vis);
        dfs(i,j-1,grid,vis);
    }
    
}