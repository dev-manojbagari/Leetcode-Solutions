class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length,cols=heights[0].length;
        int[][] minEff = new int[rows][cols];
        
        for(int[] row:minEff)
            Arrays.fill(row,Integer.MAX_VALUE);
        
        minEff[0][0]=0;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,0});
        int[][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] data = q.poll();
            int i= data[0];
            int j= data[1];
            int maxJump = data[2];
            for(int[] dir:dirs){
                int x = i+dir[0];
                int y = j+dir[1];
                
                if(x<0||x>=heights.length||y<0||y>=heights[0].length)
                    continue;
                
                 maxJump = Math.max(minEff[i][j],Math.abs(heights[i][j]-heights[x][y]));
                
                 if(minEff[x][y]>maxJump){
                     minEff[x][y]=maxJump;
                     q.offer(new int[]{x,y,maxJump});
                 }
            }
            
            
            
        }
        
        return minEff[heights.length-1][heights[0].length-1];
    }
}