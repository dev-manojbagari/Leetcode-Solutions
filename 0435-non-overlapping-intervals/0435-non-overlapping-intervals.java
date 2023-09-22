class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        
        int end = intervals[0][1];
        int count=1;
        for(int i=1;i<intervals.length;i++){
            int[] currInterval = intervals[i];
            if(end<=currInterval[0]){
                count++;
                end = currInterval[1];
            }
        }
        
        return intervals.length-count;
    }
}