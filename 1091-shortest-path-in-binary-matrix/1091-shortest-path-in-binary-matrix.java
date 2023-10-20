class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[grid.length-1][grid[0].length-1]==1)
            return -1;
        if(grid[0][0]==1)
            return -1;
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{0,0,1});
        int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
        
        int dist[][] = new int[grid.length][grid[0].length];
        
        for(int[] d:dist)
            Arrays.fill(d,Integer.MAX_VALUE);
        dist[0][0]=1;
        
        while(!q.isEmpty()){
            int[] data = q.poll();
            int i= data[0];
            int j= data[1];
            int curDist = data[2];
            
            for(int[] dir:dirs){
                int x = i+dir[0];
                int y = j+dir[1];
                
                if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]==1)
                    continue;
                
                if(dist[x][y]>1+curDist){
                    dist[x][y]=1+curDist;
                    q.offer(new int[]{x,y,1+curDist});
                }
            }
        }
        int ans = dist[grid.length-1][grid[0].length-1]; 
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}