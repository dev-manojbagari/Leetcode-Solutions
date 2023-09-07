class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        // PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a,int[] b)->b[1]*b[1]+b[0]*b[0]-a[1]*a[1]+a[0]*a[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[1]*b[1] + b[0]*b[0]) - (a[1]*a[1] + a[0]*a[0]));

        
        for(int[] point:points){
            
            if(pq.size()<k){
                pq.offer(point);
            }else if((point[1]*point[1]+point[0]*point[0]<pq.peek()[1]*pq.peek()[1]+pq.peek()[0]*pq.peek()[0])){
                pq.poll();
                pq.offer(point);
            }
        }
        

        List<int[]> list = new ArrayList<>();
        
        while(!pq.isEmpty()){
            list.add(pq.poll());
            
        }
        
        
        return list.toArray(new int[list.size()-1][2]);
        
    }
}