class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row0=false,col0=false;
        int rows=matrix.length,cols=matrix[0].length;
        
        for(int i=0;i<rows;i++){
            if(matrix[i][0]==0){
                col0=true;
                break;
            }
        }
        
        for(int i=0;i<cols;i++){
            if(matrix[0][i]==0){
                row0=true;
                break;
            }
        }
        
        
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        
        if(row0){
            for(int i=0;i<cols;i++){
                matrix[0][i]=0;
            }
        }
        
        if(col0){
            for(int i=0;i<rows;i++){
                matrix[i][0]=0;
            }
        }
    }
}