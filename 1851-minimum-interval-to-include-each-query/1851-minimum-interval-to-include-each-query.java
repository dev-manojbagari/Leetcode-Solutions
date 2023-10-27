class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] q = queries.clone();
        Arrays.sort(q);
        Map<Integer,Integer> map = new HashMap<>();
        
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        int index=0,n=intervals.length;
        
        for(int i=0;i<q.length;i++){
            
            while(index<n&&intervals[index][0]<=q[i]){
                int start = intervals[index][0],end=intervals[index][1];
                treeMap.put(end-start+1,end);
                index++;
            }
            
            while(!treeMap.isEmpty()&&treeMap.firstEntry().getValue()<q[i]){
                treeMap.pollFirstEntry();
            }
            
            map.put(q[i],treeMap.isEmpty()?-1:treeMap.firstKey());
        }
        
        int[] res = new int[q.length];
        int i=0;
        for(int num:queries)
            res[i++]=map.get(num);
        
        return res;
        
    }
}