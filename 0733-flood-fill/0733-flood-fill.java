class Solution {
    class Pair{
        int i,j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if(image[sr][sc]==color)
                return image;
        
        int intialColor = image[sr][sc];
        int rows=image.length,cols=image[0].length;
        Queue<Pair> q = new LinkedList<>();
        image[sr][sc]=color;
        q.add(new Pair(sr,sc));
        
        int[][] dirs= {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            Pair node = q.poll();
            
            for(int[] dir:dirs){
                int x= node.i+dir[0];
                int y = node.j+dir[1];
                
                if(x<0||x>=rows||y<0||y>=cols||image[x][y]!=intialColor)
                    continue;
                
                image[x][y] = color;
                q.offer(new Pair(x,y));
            }
        }
        
        
        return image;
    }
}