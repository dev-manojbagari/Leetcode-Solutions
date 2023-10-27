class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        
        for(int[] point:points){
            if(pq.size()<k){
                pq.offer(point);
            }else if(DistanceFromOrigin(point)<DistanceFromOrigin(pq.peek())){
                pq.poll();
                pq.offer(point);
            }
        }
        List<int[]> res = new ArrayList<>();
                     
        while(!pq.isEmpty())
            res.add(pq.poll());
                     
                     
         return res.toArray(new int[k][]);            
    }
                     
    int DistanceFromOrigin(int[] point){
        return point[0]*point[0]+point[1]*point[1];
    }
        
}