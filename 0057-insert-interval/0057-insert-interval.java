class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        if(intervals.length==0){
            res.add(newInterval);
            return res.toArray(new int[1][2]);
        }
       
        List<int[]> list = new ArrayList<>();
        
        for(int[] interval:intervals)
            list.add(interval);
        list.add(newInterval);
        
        list.sort((a,b)->a[0]-b[0]);
        
        for(int[] interval:list){
            System.out.println(Arrays.toString(interval));
        } 
       
        res.add(list.get(0));
        
        for(int i=1;i<list.size();i++){
            int[] lastInterval = res.get(res.size()-1);
            if(lastInterval[1]>=list.get(i)[0]){
                lastInterval[1]=Math.max(lastInterval[1],list.get(i)[1]);
            }else{
                res.add(list.get(i));
            }
        }
        
        return res.toArray(new int[res.size()-1][2]);
    }
}