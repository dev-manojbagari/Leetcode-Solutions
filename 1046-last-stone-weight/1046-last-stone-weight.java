class Solution {
    public int lastStoneWeight(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        
        for(int i=0;i<nums.length;i++)
            maxHeap.offer(nums[i]);
        
        while(maxHeap.size()>1){
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            if(a!=b)
                maxHeap.offer(a-b);
        }
        
            return maxHeap.isEmpty()?0:maxHeap.poll();        
    }
}