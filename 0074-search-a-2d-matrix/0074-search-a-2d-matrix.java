// 0(n)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int curRow = 0,curCol=matrix[0].length-1;
        
       while(curRow<matrix.length&&curCol>=0){
           
           if(matrix[curRow][curCol]==target)
               return true;
           else if(matrix[curRow][curCol]<target){
               curRow++;
           }else{
               curCol--;
           }
       }
        
       return false;        
    }
}