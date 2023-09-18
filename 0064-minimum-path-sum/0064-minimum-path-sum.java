class Solution {
    public int minPathSum(int[][] grid) {
        int[] t = new int[grid[0].length];
        
        t[0]=grid[0][0];
       
        for(int i=1;i<t.length;i++){
            t[i] = t[i-1]+grid[0][i];    
        }
        // System.out.println(Arrays.toString(t));
        for(int row = 1;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(col==0)
                    t[col]= t[col]+grid[row][col];
                else
                    t[col] = grid[row][col]+Math.min(t[col-1],t[col]);
            }
            // System.out.println(Arrays.toString(t));
        }
        
        return t[t.length-1];
        
    }
}