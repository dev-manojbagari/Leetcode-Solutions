class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> list = new ArrayList<>();
        for(int[] building:buildings){
            list.add(new int[]{building[0],-building[2]});
            list.add(new int[]{building[1],building[2]});
        }
        
        
        List<List<Integer>> res = new ArrayList<>();
        
        
       list.sort((a,b)->{
            if(a[0]!=b[0])
                return a[0]-b[0];
            return a[1]-b[1];
       }); 
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
         
        int prevHeight=0;
        
        for(int[] height:list){
            
            if(height[1]<0){
                pq.offer(-height[1]);
            }else
                pq.remove(height[1]);
            
            int curHeight = pq.isEmpty()?0:pq.peek();
            
            if(curHeight!=prevHeight){
                res.add(Arrays.asList(height[0],curHeight));
                prevHeight=curHeight;
            }
        }
        
        return res;
    }
}