class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int rows =grid.length,cols=grid[0].length; 
        int[] temp =new int[cols];
        for(int col=0;col<cols;col++){
            if(grid[0][col]==1)
                break;
            temp[col]=1;
        }        
        for(int row=1;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]==1){
                    temp[col]=0;
                }else{
                    if(col>0)
                        temp[col]+=temp[col-1];
                
                }
            }
        }
        
        return temp[cols-1]; 
    }
}