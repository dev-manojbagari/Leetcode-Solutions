class Solution {
    public int uniquePaths(int m, int n) {
        int[] temp =new int[n];
        Arrays.fill(temp,1);
        
        for(int row=1;row<m;row++){
            for(int col=1;col<n;col++){
                temp[col] = temp[col]+temp[col-1];
            }
        }
        
        return temp[n-1]; 
    }
}