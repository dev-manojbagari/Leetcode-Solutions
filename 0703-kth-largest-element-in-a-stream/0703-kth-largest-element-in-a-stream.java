class KthLargest {
    
    PriorityQueue<Integer> minHeap= new PriorityQueue<>();
    int k=0;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            if(minHeap.size()<k){
                minHeap.offer(val);
            }else{
                if(minHeap.peek()<val){
                    minHeap.poll();
                    minHeap.offer(val);
                }
            }
        }
        
    }
    
    public int add(int val) {
        if(minHeap.size()<k){
            minHeap.offer(val);
        }else{
            if(minHeap.peek()<val){
                minHeap.poll();
                minHeap.offer(val);
            }
        }
        
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */