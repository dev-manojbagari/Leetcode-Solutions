class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(0,i,j,board,word,vis))
                    return true;
            }
        }
        return false;
    }
    
    boolean dfs(int index,int i,int j,char[][] board,String word,boolean[][] vis){
        if(index==word.length())
            return true;
        
        if(i<0||i>=board.length||j<0||j>=board[0].length||vis[i][j]||board[i][j]!=word.charAt(index))
            return false;
        
        vis[i][j]=true;
        
       if(dfs(index+1,i+1,j,board,word,vis)||
          dfs(index+1,i,j+1,board,word,vis)||
          dfs(index+1,i-1,j,board,word,vis)||
          dfs(index+1,i,j-1,board,word,vis))
             return true;
        
        vis[i][j]=false;
        
        return false;
    }
}