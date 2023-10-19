class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows=mat.length,cols=mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j,0});
                }        
            }
        }
        int[][] dirs={{0,1},{1,0},{-1,0},{0,-1}};       
        int[][] res = new int[rows][cols];
        while(!q.isEmpty()){
            int[] data = q.poll();
            int i = data[0];
            int j = data[1];
            for(int[] dir:dirs){
                int x = i+dir[0];
                int y = j+dir[1];
                
                if(x<0||x>=rows||y<0||y>=cols||mat[x][y]==0)
                    continue;
                if(res[x][y]==0){
                    res[x][y]=1+data[2];
                    q.offer(new int[]{x,y,1+data[2]});
                }
            }
        }
        
        return res;
    }
}