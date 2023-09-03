class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(heights == null || heights.length == 0) return res;
        
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // Start DFS from each edge
        for(int i=0; i<m; i++){
            dfs(heights,pacific,Integer.MIN_VALUE,i,0);
            dfs(heights,atlantic,Integer.MIN_VALUE,i,n-1);
        }
        
         for(int i=0; i<n; i++){
            dfs(heights,pacific,Integer.MIN_VALUE, 0,i);
            dfs(heights,atlantic,Integer.MIN_VALUE,m-1,i);
         }
         
         // Check intersections
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                 if(pacific[i][j] && atlantic[i][j]){
                     res.add(Arrays.asList(i,j));
                 }
             }
         }
         
         return res;
    }
    
    private void dfs(int[][] heights, boolean[][] visited, int height, int x, int y){
        if(x<0 || x>=heights.length || y<0 || y>=heights[0].length || visited[x][y] || heights[x][y] < height)
            return;
        
        visited[x][y] = true;
        
        for(int[] dir: dirs){
            dfs(heights,visited,heights[x][y],x+dir[0],y+dir[1]);
        }
    } 
}
