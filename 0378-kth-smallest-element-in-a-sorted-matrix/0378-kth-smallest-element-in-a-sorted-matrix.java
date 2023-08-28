class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row=matrix.length,col=matrix[0].length;
        int left=matrix[0][0],right=matrix[row-1][col-1];
        int ans =0;
        while(left<=right){
            int mid = left+(right-left)/2;
            int cs = countSmaller(matrix,mid);
            if(cs>=k){
                 ans = mid;
                 right=mid-1;}
            else{
                left=mid+1;
            }
        }
        
        return ans;
        
    }
    
    int countSmaller(int[][] matrix,int val){
        int row = matrix.length-1,col=0;
        int count =0;
        while(col<matrix[0].length&&row>=0){
            
            if(matrix[row][col]<=val){
                count+=row+1; 
                col++;
            }else
                row--;
        }
        return count;
    }
    
}