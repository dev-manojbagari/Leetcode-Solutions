class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] q = queries.clone();
        Arrays.sort(q);
        Map<Integer,Integer> map = new HashMap<>();
        int index=0,n=intervals.length;
        for(int query:q){
            
            while(index<n&&intervals[index][0]<=query){
                int start=intervals[index][0],end=intervals[index][1];
                treeMap.put(end-start+1,end);
                index++;
            }
            
            while(!treeMap.isEmpty()&&treeMap.firstEntry().getValue()<query){
                treeMap.pollFirstEntry();
            }

            map.put(query,treeMap.isEmpty()?-1:treeMap.firstKey());
        }
        int[] res = new int[q.length];
        for(int i=0;i<queries.length;i++)
            res[i] = map.get(queries[i]);
        
        return res;
    }
}