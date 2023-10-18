class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int min=matrix[0][0],max=matrix[matrix.length-1][matrix[0].length-1];

        int left=min,right=max;
        int ans =0;
        while(left<=right){
            int mid= left+(right-left)/2;
            int index = countSmallerOrEqual(matrix,mid);
            if(index>=k){
                ans = mid;
                right=mid-1;
            }else
                left=mid+1;
        }
        
        return ans;        
    }
    
    int countSmallerOrEqual(int[][] matrix,int val){
        int count=0;
        int row = matrix.length-1,col=0;
        
        while(row>=0&&col<matrix[0].length){
            if(matrix[row][col]<=val){
                count+=row+1;
                col++;
            }else
                row--;
        }
        return count;        
    }
}