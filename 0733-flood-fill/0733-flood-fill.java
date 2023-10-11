class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)
            return image;
        int oc = image[sr][sc];
        dfs(sr,sc,image,color,oc);
        
        
        
        return image;
    }
    
    
    void dfs(int i,int j,int[][] image,int color,int oc){
        
        if(i<0||i>=image.length||j<0||j>=image[0].length||image[i][j]!=oc)
            return;
        
        image[i][j]=color;
        
        dfs(i+1,j,image,color,oc);
        dfs(i,j+1,image,color,oc);
        dfs(i-1,j,image,color,oc);
        dfs(i,j-1,image,color,oc);
        
        
        
    }
    
    
}