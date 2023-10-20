class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] minTime = new int[n+1];
        Arrays.fill(minTime,Integer.MAX_VALUE);
        minTime[k]=0;
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        q.offer(new int[]{k,0});
        
        List<List<int[]>> list = new ArrayList<>();
        
        for(int i=0;i<=n;i++)
            list.add(new ArrayList<>());
        
        for(int i=0;i<times.length;i++){
            list.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});
        }
        
        while(!q.isEmpty()){
            int[] data = q.poll();
            int curNode = data[0];
            int curTime = data[1];
            
            for(int[] x:list.get(curNode)){
                int nbrNode = x[0];
                int nbrTime = x[1];
                
                if(curTime+nbrTime<minTime[nbrNode]){
                    minTime[nbrNode]=curTime+nbrTime;
                    q.offer(new int[]{nbrNode,minTime[nbrNode]});
                }
            }
        }
        int max=-1;
        for(int i=1;i<=n;i++)
            max =Math.max(max,minTime[i]);
        
        return max==Integer.MAX_VALUE?-1:max;
    }
}