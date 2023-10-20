class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<flights.length;i++){
                adj.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});    
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        int[] minCost = new int[n];
        
        Arrays.fill(minCost,Integer.MAX_VALUE);
        minCost[src]=0;
        
        pq.offer(new int[]{src,0,0});
        
        while(!pq.isEmpty()){
            int[] data =pq.poll();
            int curSrc = data[0];
            int curCost = data[1];
            int curStop = data[2];
            
            for(int[] x:adj.get(curSrc)){
              int curDest = x[0];
              int curDestCost = x[1];
              
              if(1+curStop<=k+1&&(curCost+curDestCost<minCost[curDest])){
                  minCost[curDest]=curCost+curDestCost;
                  pq.offer(new int[]{curDest,minCost[curDest],1+curStop});
              }
            }
        }
        
        
        return minCost[dst]==Integer.MAX_VALUE?-1:minCost[dst];        
        
    }
}