class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1])));
    
         for(int[] point:points){
             if(pq.size()<k){
                 pq.offer(point);
             }else if(distanceFromOrigin(point)<distanceFromOrigin(pq.peek())){
                 pq.poll();
                 pq.offer(point);
             }
         }
        int[][] res = new int[k][2];
        int index=0;
        while(!pq.isEmpty()){
            res[index++] = pq.poll();
        }
        
        return res;
}
int distanceFromOrigin(int[] p){
    return p[0]*p[0]+p[1]*p[1];
}


}