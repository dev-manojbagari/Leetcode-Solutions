class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length,cols=matrix[0].length;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i<j){
                    int temp = matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
        }
        
        int left=0,right=cols-1;
        
        while(left<right){
            for(int i=0;i<rows;i++){
                int temp = matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
            }
            left++;
            right--;
        }
    }
}