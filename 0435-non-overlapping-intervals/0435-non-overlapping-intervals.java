class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        
        for(int[] interval:intervals){
            list.add(interval);
        }
        
        list.sort((a,b)->a[1]-b[1]);
        
        int count=1;
        int end = list.get(0)[1];
        for(int i=1;i<list.size();i++){
           
            if(list.get(i)[0]>=end){
                count++;
                end = list.get(i)[1];
            }
            
        }
     
        
//         int count=1;
//         int end = list.get(0)[1];
        
//         for(int i=1;i<list.size();i++){
//             if(list.get(i)[0] >= end){
//                 // Non-overlapping interval found, increment count
//                 count++;
//                 // Update end time to this non-overlapping interval's end time.
//                 end = list.get(i)[1];
//             }
            
//         }
     
        
        return list.size()-count;
    }
}