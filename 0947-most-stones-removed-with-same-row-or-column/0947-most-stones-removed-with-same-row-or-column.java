class Solution {
    class DSU{
        int[] parent;
        int[] size;
        
        DSU(int n){
            parent = new int[n];
            size = new int[n];

            for(int i=0;i<n;i++)
            {
                parent[i]=i;
                size[i]=1;
            }
        }
        
        int findUP(int x){
            if(parent[x]==x)
                return x;
            int up = findUP(parent[x]);
            parent[x]=up;
            return up;
        }
        
        void unionBySize(int a,int b){
            int upA = findUP(a);
            int upB = findUP(b);
            if(upA==upB)
                return;
            if(size[upA]>=size[upB]){
                size[upA]+=size[upB];
                parent[upB]=upA;
            }else{
                size[upB]+=size[upA];
                parent[upA]=upB;
            }
            
        }
    }
    
    public int removeStones(int[][] stones) {
        int maxRowNo = Integer.MIN_VALUE;
        int maxColNo = Integer.MIN_VALUE;
        
        for(int i=0;i<stones.length;i++){
            int row= stones[i][0];
            int col = stones[i][1];
            maxRowNo = Math.max(maxRowNo,row);
            maxColNo = Math.max(maxColNo,col);
        }
        
        DSU dsu = new DSU(maxRowNo+maxColNo+2);
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<stones.length;i++){
            int row = stones[i][0];
            int col = stones[i][1]+maxRowNo+1;
            dsu.unionBySize(row,col);
            set.add(row);
            set.add(col);
        }
        
        int c =0;
        for(int x:set)
            if(dsu.findUP(x)==x)
                c++;
        
        
        return stones.length-c;
    }
}