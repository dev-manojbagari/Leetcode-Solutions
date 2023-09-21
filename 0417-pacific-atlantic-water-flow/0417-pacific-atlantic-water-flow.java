class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] mat) {
        int rows = mat.length,cols=mat[0].length;
        
        boolean[][] po = new boolean[rows][cols];
        boolean[][] ao = new boolean[rows][cols];
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0||j==0){
                    dfs(i,j,mat,po,-1);
                }
            }
        }
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==rows-1||j==cols-1){
                    dfs(i,j,mat,ao,-1);
                }
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(po[i][j]&&ao[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        
        return res;
    }
    
    void dfs(int i,int j,int[][] mat,boolean[][] vis,int prev){
        
        if(i<0||i>=mat.length||j<0||j>=mat[0].length||vis[i][j]||prev>mat[i][j])
            return;
        
        vis[i][j]=true;
        
         dfs(i+1,j,mat,vis,mat[i][j]);
         dfs(i,j+1,mat,vis,mat[i][j]);
         dfs(i-1,j,mat,vis,mat[i][j]);
         dfs(i,j-1,mat,vis,mat[i][j]);
    }
    
    
}