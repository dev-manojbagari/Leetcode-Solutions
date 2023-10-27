class Solution {
    record Job(int startTime,int endTime,int profit){};
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        
        for(int i=0;i<startTime.length;i++){
            jobs.add(new Job(startTime[i],endTime[i],profit[i]));
        }
        
        jobs.sort((a,b)->a.endTime-b.endTime);
        
        List<Integer> dpEndTime = new ArrayList<>();
        List<Integer> dpProfit = new ArrayList<>();
        dpEndTime.add(0);
        dpProfit.add(0);
        
        for(Job job:jobs){
            
            int prevIdx = largestSmaller(job.startTime+1,dpEndTime);
            
            int takeJob = dpProfit.get(prevIdx)+job.profit;
            int doNotTakeJob = dpProfit.get(dpProfit.size()-1);
            
            if(takeJob>doNotTakeJob){
                dpEndTime.add(job.endTime);
                dpProfit.add(takeJob);
            }
            
        }
        return dpProfit.get(dpProfit.size()-1);
    }
    
    int largestSmaller(int val,List<Integer> list){
        int left=0,right=list.size()-1;
        int ans = -1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(list.get(mid)<val){
                ans =mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        
        return ans;        
    }
    
}