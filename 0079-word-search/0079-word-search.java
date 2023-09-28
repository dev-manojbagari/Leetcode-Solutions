class Solution {
    public boolean exist(char[][] board, String word) {
        int rows= board.length,cols=board[0].length;
        boolean[][] vis = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!vis[i][j]&&board[i][j]==word.charAt(0)){
                    if(dfs(i,j,board,0,word,vis))
                        return true;
                }
            }
        }
        
        return false;
    }
    
    
    boolean dfs(int i,int j,char[][] board,int curIndex,String word,boolean[][] vis){
        
        if(i<0||i>=board.length||j<0||j>=board[0].length||vis[i][j]||word.charAt(curIndex)!=board[i][j])
            return false;
        
        vis[i][j]=true;
        
        if(curIndex==word.length()-1&&word.charAt(curIndex)==board[i][j])
            return true;
        
        if(dfs(i+1,j,board,curIndex+1,word,vis)||
           dfs(i,j+1,board,curIndex+1,word,vis)||
           dfs(i-1,j,board,curIndex+1,word,vis)||
           dfs(i,j-1,board,curIndex+1,word,vis))
            return true;
        vis[i][j]=false;
        return false;
    }
}