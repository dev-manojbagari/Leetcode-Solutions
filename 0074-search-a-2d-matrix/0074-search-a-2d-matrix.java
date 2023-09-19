class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0,right = matrix.length*matrix[0].length-1;
        int cols = matrix[0].length;
        while(left<=right){
            int mid = left+(right-left)/2;
            
            int row = mid/cols;
            int col = mid%cols;
            int val = matrix[row][col];
            if(val==target){
                return true;
            }else if(val<target)
            {
                left = mid+1;
            }else
                right = mid-1;
        }
        
        return false;
    }
}