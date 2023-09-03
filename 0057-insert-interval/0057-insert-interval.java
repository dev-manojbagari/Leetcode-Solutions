class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        
        int start = newInterval[0];
        int end =   newInterval[1];
        
        int i=0;
        int n = intervals.length;
        while(i<n&&intervals[i][1]<start)
            res.add(intervals[i++]);
        
        while(i<n&&intervals[i][0]<=end){
            start = Math.min(intervals[i][0],start);
            end =   Math.max(intervals[i][1],end);
            i++;
        }
        
        res.add(new int[]{start,end});
        
        while(i<n)
            res.add(intervals[i++]);
        
        return res.toArray(new int[res.size()][2]);
    }
}