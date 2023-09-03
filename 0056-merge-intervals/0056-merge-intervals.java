class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        list.add(intervals[0]);
        
        for(int i=1;i<intervals.length;i++){
            int[] lastInterval = list.get(list.size()-1);
            if(lastInterval[1]>=intervals[i][0]){
                lastInterval[1]=Math.max(lastInterval[1],intervals[i][1]);
            }else{
                list.add(intervals[i]);
            }
        }
        
        return list.toArray(new int[list.size()-1][2]);
        
    }
}