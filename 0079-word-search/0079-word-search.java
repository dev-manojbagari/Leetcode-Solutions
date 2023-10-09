class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                 if(board[i][j]==word.charAt(0)){
                     if(dfs(i,j,board,vis,0,word)){
                         return true;
                     }
                 }        
            }
        }
        
        return false;
    }
    
    
    boolean dfs(int i,int j,char[][] board,boolean[][] vis,int index,String word){
        if(index==word.length())
            return true;
        
        if(i<0||i>=board.length||j<0||j>=board[0].length||vis[i][j]||word.charAt(index)!=board[i][j])
            return false;
        
        vis[i][j]=true;
        
        if(dfs(i+1,j,board,vis,index+1,word)||
        dfs(i,j+1,board,vis,index+1,word)||
        dfs(i-1,j,board,vis,index+1,word)||
        dfs(i,j-1,board,vis,index+1,word))
            return true;
        
        vis[i][j]=false;
        
        return false;
    }
}