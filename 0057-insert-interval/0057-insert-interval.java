class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int start = newInterval[0];
        int end =  newInterval[1];
        int index=0,n=intervals.length;
        while(index<n&&intervals[index][1]<start){
            list.add(intervals[index]);
            index++;
        }
        
        while(index<n&&intervals[index][0]<=end){
            start = Math.min(start,intervals[index][0]);
            end = Math.max(end,intervals[index][1]);
            index++;
        }
        
        list.add(new int[]{start,end});
        
        while(index<n){
            list.add(intervals[index++]);
        }
        
        
        return list.toArray(new int[list.size()][2]);
    }
}