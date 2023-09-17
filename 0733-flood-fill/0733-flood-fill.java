class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initColor = image[sr][sc];
        if(initColor==color)
            return image;
        
        // image[sr][sc]=color;
        
        dfs(sr,sc,image,color,initColor); 
        
        return image;
    }
    
    void dfs(int i,int j,int[][] image,int color,int initColor){
        
        if(i<0||i>=image.length||j<0||j>=image[0].length||image[i][j]!=initColor)
            return;
        
        image[i][j] = color;
        
         dfs(i+1,j,image,color,initColor);
         dfs(i,j+1,image,color,initColor);
         dfs(i-1,j,image,color,initColor);
         dfs(i,j-1,image,color,initColor);
        
    }
}