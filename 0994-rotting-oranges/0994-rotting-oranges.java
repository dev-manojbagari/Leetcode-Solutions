class Solution {
    class Pair{
        int i,j,curTime;
        Pair(int i,int j,int curTime){
            this.i=i;
            this.j=j;
            this.curTime=curTime;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        int rows=grid.length,cols=grid[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
        int minTime = 0;
        int freshOranges=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                }else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        
        while(!q.isEmpty()){
            Pair node = q.poll();
            
            for(int[] dir:dirs){
                int x= node.i+dir[0];
                int y = node.j+dir[1];
                
                if(x<0||x>=rows||y<0||y>=cols||grid[x][y]!=1)
                    continue;
                
                grid[x][y]=2;
                freshOranges--;
                q.offer(new Pair(x,y,node.curTime+1));
                minTime = node.curTime+1;
            }
        }
        
        return freshOranges!=0?-1:minTime;
    }
}