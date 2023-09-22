class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows= mat.length,cols=mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[rows][cols];
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                    vis[i][j]=true;
                }
            }
        }
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int i = cell[0];
            int j = cell[1];
            
            for(int[] dir:dirs){
                int x = i+dir[0];
                int y = j+dir[1];
                
                if(x<0||x>=mat.length||y<0||y>=mat[0].length||vis[x][y])
                    continue;
                
                vis[x][y]=true;
                mat[x][y] = mat[i][j]+1;
                q.offer(new int[]{x,y});
            }
        }
        
        
        return mat;        
    }
}