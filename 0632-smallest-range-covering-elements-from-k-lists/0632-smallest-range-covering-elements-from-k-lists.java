class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++){
            pq.offer(new int[]{nums.get(i).get(0),0,i});
            max = Math.max(max,nums.get(i).get(0)); 
        }
        
        int minRange = Integer.MAX_VALUE;
        int start=0;
        
        while(pq.size()==nums.size()){
            int[] data = pq.poll();
            int curVal = data[0];
            int curIndex=data[1];
            int curList = data[2];
            
            if(max-curVal+1<minRange){
                minRange= max-curVal+1;
                start = curVal;
            }
            
            if(curIndex+1<nums.get(curList).size()){
                int nextNum = nums.get(curList).get(curIndex+1);
                pq.offer(new int[]{nums.get(curList).get(curIndex+1),curIndex+1,curList});
                max = Math.max(max,nextNum);
            }
        }
        
        return new int[]{start,start+minRange-1};
        
    }
}