class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->(b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
    
        for(int[] point:points){
            if(maxHeap.size()<k){
                maxHeap.offer(point);
            }else {
                int[] curPoint = maxHeap.peek();
                int[] origin = {0,0};
                if(getDistance(curPoint,origin)>getDistance(point,origin)){
                    maxHeap.poll();
                    maxHeap.offer(point);
                }
            }
        }
        
        List<int[]> list = new ArrayList<>();
        
        while(!maxHeap.isEmpty()){
            list.add(maxHeap.poll());
        }
        
        return list.toArray(new int[list.size()][2]);
    
    }
    
    
    int getDistance(int[] a,int[] b){
        return (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
    }
}