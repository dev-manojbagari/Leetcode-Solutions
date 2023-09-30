class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] q = queries.clone();
        Arrays.sort(q);
        int[] res = new int[q.length];
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        int index=0;
        Map<Integer,Integer> resMap= new HashMap<>();
        for(int i=0;i<q.length;i++){
            
            while(index<intervals.length&&intervals[index][0]<=q[i]){
                int start = intervals[index][0],end = intervals[index][1];
                treeMap.put(end-start+1,end);
                index++;
            }
            
            while(!treeMap.isEmpty()&&treeMap.firstEntry().getValue()<q[i]){
                treeMap.pollFirstEntry();
            }
            
            resMap.put(q[i],treeMap.isEmpty()?-1:treeMap.firstKey());
        }
        
        for(int i=0;i<queries.length;i++){
            res[i] = resMap.get(queries[i]);
        }        
        
        return res;
    }
}