class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        
        int rows=grid.length,cols=grid[0].length;
        pq.offer(new int[]{0,0,grid[0][0]});
        int max=0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int[][] time = new int[rows][cols];
        for(int[] r:time)
            Arrays.fill(r,Integer.MAX_VALUE);
        time[0][0]=grid[0][0];
        while(!pq.isEmpty()){
            int data[] = pq.poll();
            int i = data[0];
            int j = data[1];
            
            for(int[] dir:dirs){
                int x = i+dir[0];
                int y = j+dir[1];
                
                if(x<0||x>=rows||y<0||y>=cols)
                    continue;
                
                int curMax = Math.max(time[i][j],grid[x][y]);
                if(time[x][y]>curMax){
                    time[x][y]=curMax;
                    pq.offer(new int[]{x,y,curMax});
                }
            }
        }
        
        
        return time[rows-1][cols-1];
    }
} 