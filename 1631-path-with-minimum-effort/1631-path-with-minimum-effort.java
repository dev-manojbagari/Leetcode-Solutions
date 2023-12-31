class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length,cols=heights[0].length;
        int[][] minEff = new int[rows][cols];
        
        for(int[] row:minEff)
            Arrays.fill(row,Integer.MAX_VALUE);
        
        minEff[0][0]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,0});
        int[][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()){
            int[] data = pq.poll();
            int i= data[0];
            int j= data[1];
            for(int[] dir:dirs){
                int x = i+dir[0];
                int y = j+dir[1];
                
                if(x<0||x>=heights.length||y<0||y>=heights[0].length)
                    continue;
                
                 int newEff = Math.max(data[2],Math.abs(heights[i][j]-heights[x][y]));
                
                 if(minEff[x][y]>newEff){
                     minEff[x][y]=newEff;
                     pq.offer(new int[]{x,y,newEff});
                 }
            }
            
            
            
        }
        
        return minEff[heights.length-1][heights[0].length-1];
    }
}