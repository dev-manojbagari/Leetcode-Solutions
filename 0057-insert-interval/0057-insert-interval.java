class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int start = newInterval[0];
        int end = newInterval[1];
    

        while (i < intervals.length && intervals[i][1] < start) {
                result.add(intervals[i++]);
        }

        while (i < intervals.length && intervals[i][0] <= end) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
                i++;
        }
        result.add(new int[]{start,end}); 

        while (i < intervals.length) 
            result.add(intervals[i++]);
        
        return result.toArray(new int[0][]);
    }
}
