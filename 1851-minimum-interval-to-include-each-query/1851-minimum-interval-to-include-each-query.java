class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
         int[] q = queries.clone();
         Arrays.sort(q);
         Arrays.sort(intervals,(a,b)->a[0]-b[0]);
         TreeMap<Integer,Integer> treeMap = new TreeMap<>();
         Map<Integer,Integer> map = new HashMap<>();
        int index=0;
        
        for(int i=0;i<q.length;i++){
             int query = q[i];
             while(index<intervals.length&&intervals[index][0]<=query){
                 treeMap.put(intervals[index][1]-intervals[index][0]+1,intervals[index][1]);
                 index++;
             }
            
             while(!treeMap.isEmpty()&&treeMap.firstEntry().getValue()<query)
                    treeMap.pollFirstEntry();
             
             map.put(query,treeMap.isEmpty()?-1:treeMap.firstKey());
             
         }
        
         int[] res =new int[q.length];
        
        for(int i=0;i<queries.length;i++){
            res[i]=map.get(queries[i]);
        }
            
        return res;
    }
}