class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length,cols=grid[0].length;
        int freshOranges=0;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j,0});
                }else if(grid[i][j]==1){ 
                    freshOranges++;
                }
            }
        }
        // System.out.println(freshOranges);
        int max=0;
        int[][] dirs={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] data = q.poll();
            int i = data[0];
            int j = data[1];
            int time = data[2];
            max = Math.max(max,time);
            for(int[] dir:dirs){
                int x = i+dir[0];
                int y = j+dir[1];
                
                if(x<0||x>=grid.length||y<0||y>=grid[0].length)
                    continue;
                
                if(grid[x][y]==1){
                    grid[x][y]=2;
                    freshOranges--;
                    q.offer(new int[]{x,y,time+1});
                }
                
            }
        }
                // System.out.println(freshOranges);

        
        return freshOranges==0?max:-1;
    }
}