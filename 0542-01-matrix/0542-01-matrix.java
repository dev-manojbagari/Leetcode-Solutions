class Solution {
    class Pair{
        int i=0,j=0,dist=0;;
        Pair(int i,int j,int dist){
            this.i =i;
            this.j = j;
            this.dist=dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int rows=mat.length,cols=mat[0].length;
        boolean[][] vis = new boolean[rows][cols];
        int[][] dist = new int[rows][cols];        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=true;
                }        
            }
        }
        int[][] dirs ={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            
            Pair curNode = q.poll();
            
            for(int[] dir:dirs){
                int x = curNode.i+dir[0];
                int y = curNode.j+dir[1];
                
                if(x<0||x>=mat.length||y<0||y>=mat[0].length||vis[x][y]==true)
                        continue;
                
                    if(mat[x][y]==1){
                        dist[x][y]=curNode.dist+1;
                        vis[x][y]=true;
                        q.add(new Pair(x,y,curNode.dist+1));
                    }
            }
            
        }
        
        return dist;
    }
    
    
}