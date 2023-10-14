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
        PriorityQueue<Data> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        int max=Integer.MIN_VALUE;
        int n =nums.size();
        for(int i=0;i<n;i++){
            pq.offer(new Data(nums.get(i).get(0),0,i));
            max = Math.max(max,nums.get(i).get(0));
        }
        
        int[] res = new int[2];
        int range = Integer.MAX_VALUE;
        int start=0;
        while(pq.size()==n){
            Data data = pq.poll();
            
            if(max-data.val<range){
                range=max-data.val;
                res[0]=data.val;
                res[1]=max;
                //start=data.val;
            }
            
            if(data.index+1<nums.get(data.listIndex).size()){
                Data next = new Data(nums.get(data.listIndex).get(data.index+1),data.index+1,data.listIndex);
                pq.offer(next);
                max=Math.max(max,next.val);
            }          
            
        }
        // res[0]=start;
        // res[1]=start+range;
        return res;
    }
}