class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(!maxHeap.isEmpty()&&maxHeap.peek()<num){
            minHeap.offer(num);
            if(minHeap.size()>1+maxHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
        }else{
            maxHeap.offer(num);
            if(maxHeap.size()>1+minHeap.size()){
                minHeap.offer(maxHeap.poll());
            }
        }
        
    }
    
    public double findMedian() {
        int n =minHeap.size()+maxHeap.size();
        if(n%2==0){
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }else{
            if(minHeap.size()>maxHeap.size())
                return minHeap.peek();
            else
                return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */