class Solution {
    class DSU{
        int[] parent;
        int[] size;

        DSU(int n){
            parent= new int[n];
            size =  new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        
        int findUP(int i){
            if(i==parent[i])
                return i;
            int ulP = findUP(parent[i]);
            parent[i]=ulP;
            return ulP;
        }
        
        void unionBySize(int a,int b){
            int upA = findUP(a);
            int upB = findUP(b);
            
            if(upA==upB)
                return;
            if(size[upA]<size[upB]){
                size[upB]+=size[upA];
                parent[upA]=upB;
            }else{
                size[upA]+=size[upB];
                parent[upB]=upA;
            }
        }
    }
    
    
    public int makeConnected(int n, int[][] connections) {
        DSU dsu = new DSU(n);
        int ee=0;
        
        for(int[] connection:connections){
            if(dsu.findUP(connection[0])==dsu.findUP(connection[1]))
                ee++;
            else
                dsu.unionBySize(connection[0],connection[1]);
        }
        
        int component=0;
        
        for(int i=0;i<n;i++){
            if(dsu.findUP(i)==i)
               component++;
        }
        
        return ee>=component-1?component-1:-1;
    }
}