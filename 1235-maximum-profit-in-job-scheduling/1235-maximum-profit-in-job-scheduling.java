class Solution {
    // class Job{
    //     int startTime,endTime,profit;
    //     Job(int startTime,int endTime,int profit){
    //         this.startTime=startTime;
    //         this.endTime=endTime;
    //         this.profit= profit;
    //     }
    // }
    record Job(int startTime,int endTime,int profit){}
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        List<Job> jobs = new ArrayList<>();
        for(int i=0;i<startTime.length;i++){
            jobs.add(new Job(startTime[i],endTime[i],profit[i]));
        }
        
        jobs.sort((a,b)->Integer.compare(a.endTime(),b.endTime()));
        
        
        List<Integer> endTimes = new ArrayList<>();
        List<Integer> dpProfit = new ArrayList<>();
        endTimes.add(0);
        dpProfit.add(0);
        for(Job job:jobs){
            int prevJobId = prevJob(endTimes,job.startTime);
            
            int inclProfit = dpProfit.get(prevJobId)+job.profit;
            int exclProfit = dpProfit.get(dpProfit.size()-1);
            
            if(inclProfit>exclProfit){
                endTimes.add(job.endTime());
                dpProfit.add(inclProfit);
            }
        }
        
        return dpProfit.get(dpProfit.size()-1);
    }
    
    int prevJob(List<Integer> endTimes,int startTime){
        int left =  0,right =endTimes.size()-1;
        int ans =-1;
        while(left<=right){
            int mid  = left+(right-left)/2;
            
            if(endTimes.get(mid)<=startTime){
                ans = mid;
                left = mid+1;
            }else
                right = mid-1;
        }
        
        return ans;
    }
}