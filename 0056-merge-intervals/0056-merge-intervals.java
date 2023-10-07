class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        list.add(intervals[0]);
        int[] prevInterval = intervals[0];
        for(int i=1;i<intervals.length;i++){
            int[] curInterval = intervals[i];
            if(prevInterval[1]>=curInterval[0]){
                prevInterval[1]= Math.max(prevInterval[1],curInterval[1]);
            }else{
                list.add(curInterval);
                prevInterval = curInterval;
            }
        }
        
        return list.toArray(new int[list.size()][2]);
        
    }
}