class Solution {
    class DSU{
        int[] parent;
        int[] size;
        DSU(int n){
            parent=new int[n];
            size=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        
        int findUP(int i){
            if(parent[i]==i)
                return i;
            int up  = findUP(parent[i]);
            parent[i]=up;
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
        int n=grid.length;
        DSU dsu = new DSU(n*n);
        int[][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                for(int[] dir:dirs){
                    int x =dir[0]+i;
                    int y = dir[1]+j;
                    
                    if(x<0||x>=n||y<0||y>=n||grid[x][y]==0)
                        continue;
                    
                    dsu.unionBySize(x*n+y,i*n+j);
                }
               }
            }
        }
        
        int max = Arrays.stream(dsu.size).max().getAsInt();
        Set<Integer> set = new HashSet<>();
         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                for(int[] dir:dirs){
                    int x =dir[0]+i;
                    int y = dir[1]+j;
                    
                    if(x<0||x>=n||y<0||y>=n||grid[x][y]==0)
                        continue;
                    
                    if(dsu.findUP(x*n+y)!=dsu.findUP(i*n+j))
                        set.add(dsu.findUP(x*n+y));
                }
                 int total = 1;
                 for(int temp:set)
                     total+= dsu.size[temp];
                    
                max = Math.max(max,total);
                set.clear();
               }
            }
        }
        
        
        return max;
    }
}