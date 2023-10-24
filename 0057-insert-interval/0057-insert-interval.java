class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int index=0;
        int n = intervals.length;
        
        while(index<n&&intervals[index][1]<newInterval[0]){
            list.add(intervals[index]);
            index++;
        }
        
        int start=newInterval[0],end=newInterval[1];
        while(index<n&&intervals[index][0]<=newInterval[1]){
            start = Math.min(intervals[index][0],start);
            end =   Math.max(intervals[index][1],end);
            index++;
        }
        
        list.add(new int[]{start,end});
        
        while(index<n)
            list.add(intervals[index++]);
        
        
        return list.toArray(new int[list.size()][2]);
        
    }
}