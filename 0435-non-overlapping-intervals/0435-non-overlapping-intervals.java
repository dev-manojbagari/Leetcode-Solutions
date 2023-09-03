public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        // Sort by end time
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        
        int count = 1; // At least one interval will be there
        int end = intervals[0][1]; // End time of first interval
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) { // If this interval starts after or at the same time as previous ends
                count++; // We can keep this interval
                end = intervals[i][1]; // Update end time to this interval's end time.
            }
        }
        
        return intervals.length - count; // The rest need to be removed.
    }
}