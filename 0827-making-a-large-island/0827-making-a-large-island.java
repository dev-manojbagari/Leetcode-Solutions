class Solution {
    
    class DSU{
        int[] parent;
        int[] size;
        DSU(int n){
            parent = new int[n];
            size= new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
            
        }
        
        int findUP(int a){
            if(parent[a]==a)
                return a;
            int up = findUP(parent[a]);
            parent[a]=up;
            return up;
        }
    
        void unionBySize(int a,int b){
            int upA = findUP(a);
            int upB = findUP(b);
            
            if(upA==upB)
                return;
            if(size[upA]<=size[upB]){
                size[upB]+=size[upA];
                parent[upA]=upB;
            }else{
                size[upA]+=size[upB];
                parent[upB]=upA;
            }
        }
    }
    
    public int largestIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        DSU dsu = new DSU(rows * cols);
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int curRow = 0; curRow < rows; curRow++) {
            for(int curCol = 0; curCol < cols; curCol++) {
                if(grid[curRow][curCol] == 1) {
                    for(int[] dir : dirs) {
                        int x = dir[0] + curRow;
                        int y = dir[1] + curCol;
                        
                        if(x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == 0)
                            continue;
                        dsu.unionBySize(x * cols + y, curRow * cols + curCol);
                    }
                }
            }
        }
        int max = Arrays.stream(dsu.size).max().getAsInt();
        Set<Integer> set = new HashSet<>();
        for(int curRow = 0; curRow < rows; curRow++) {
            for(int curCol = 0; curCol < cols; curCol++) {
                if(grid[curRow][curCol] == 0) {
                    for(int[] dir : dirs) {
                        int x = dir[0] + curRow;
                        int y = dir[1] + curCol;
                        
                        if(x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == 0)
                            continue;
                        if(dsu.findUP(x * cols + y) != dsu.findUP(curRow * cols + curCol))
                            set.add(dsu.findUP(x * cols + y));
                    }
                    int total = 1;
                    for(int i : set)
                        total += dsu.size[i];
                    max = Math.max(max, total);
                    set.clear();
                }
            }
        }
        return max;
    }
}