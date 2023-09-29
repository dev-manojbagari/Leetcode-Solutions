class Solution {
    class Data{
        int val,index,listIndex;
        Data(int val,int index,int listIndex){
            this.val=val;
            this.index=index;
            this.listIndex=listIndex;
        }
    }
    
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Data> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        int n = nums.size();
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            pq.offer(new Data(nums.get(i).get(0),0,i));
            max = Math.max(max,nums.get(i).get(0));
        }
        
        int[] res = new int[2];
        int start=0;
        int minRange = Integer.MAX_VALUE;
        while(pq.size()==n){
            Data data = pq.poll();
            
            if(max-data.val+1<minRange){
                minRange = max-data.val+1;
                start = data.val;
            }
            
            int curIndex = data.index;
            int curListIndex = data.listIndex;
            int curListSize =  nums.get(curListIndex).size();
            
            if(curIndex+1<curListSize){
                int num = nums.get(curListIndex).get(curIndex+1);
                pq.offer(new Data(num,curIndex+1,curListIndex));
                max = Math.max(max,num);
            }
        }
        
        return new int[]{start ,start+minRange-1};
    }
}