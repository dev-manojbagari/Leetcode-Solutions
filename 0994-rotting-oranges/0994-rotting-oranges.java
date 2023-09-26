class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int rows=grid.length,cols=grid[0].length;
        int freshOranges=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j,0});
                }else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int time=0;
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int i= cell[0];
            int j= cell[1];
            int curTime = cell[2];
            for(int[] dir:dirs){
                int x = i+dir[0];
                int y = j+dir[1];
            
                if(x<0||x>=rows||y<0||y>=cols||grid[x][y]!=1)
                    continue;
            
                grid[x][y]=2;
                freshOranges--;
                time = Math.max(time,curTime+1);
                q.offer(new int[]{x,y,curTime+1});
            }
            
        }
        
        
            
        return freshOranges==0?time:-1;    
    }
}