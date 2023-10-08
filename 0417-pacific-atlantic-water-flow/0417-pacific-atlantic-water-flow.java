class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] h) {
        int rows=h.length,cols=h[0].length;
        boolean[][] po = new boolean[rows][cols];
        boolean[][] ao = new boolean[rows][cols];
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0||j==0){
                    dfs(i,j,h,po,-1);
                }
            }
        }
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==rows-1||j==cols-1){
                    dfs(i,j,h,ao,-1);
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(ao[i][j]&&po[i][j]){
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        
        
        return list;
        
    }
    
     void dfs(int i,int j,int[][] grid,boolean[][] vis,int prev){
        
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||vis[i][j]||prev>grid[i][j])
            return;
        vis[i][j]=true;
        
        dfs(i+1,j,grid,vis,grid[i][j]);
        dfs(i,j+1,grid,vis,grid[i][j]);
        dfs(i-1,j,grid,vis,grid[i][j]);
        dfs(i,j-1,grid,vis,grid[i][j]);
    }
}