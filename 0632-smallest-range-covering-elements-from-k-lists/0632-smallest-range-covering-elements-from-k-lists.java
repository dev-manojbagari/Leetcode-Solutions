class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap= new PriorityQueue<>((a,b)->a[0]-b[0]);
        int max=nums.get(0).get(0);

        for(int i=0;i<nums.size();i++){
            minHeap.offer(new int[]{nums.get(i).get(0),i,0});
            max = Math.max(max,nums.get(i).get(0));
        }
        int minRange = Integer.MAX_VALUE;
        int start =0;
        while(minHeap.size()==nums.size()){
            int[] data = minHeap.poll();
             
            if(max-data[0]+1<minRange){
                minRange = max-data[0]+1;
                start = data[0];
            }
            
            int curIndex = data[2];
            int curList = data[1];
            int curListSize = nums.get(curList).size();
            
            if(curIndex+1<curListSize){
                int nextNum = nums.get(curList).get(curIndex+1);
                minHeap.offer(new int[]{nextNum,curList,curIndex+1});
                max = Math.max(max,nextNum);
            }
                     
        }
        
        
        
        return new int[]{start,start+minRange-1};
    }
}