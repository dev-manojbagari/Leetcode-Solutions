class Solution {
    class Job{
        int startTime,endTime,profit;
        Job(int startTime,int endTime,int profit){
            this.startTime=startTime;
            this.endTime=endTime;
            this.profit=profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<Job> jobs = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            jobs.add(new Job(startTime[i],endTime[i],profit[i]));
        }
        
        jobs.sort((a,b)->a.endTime-b.endTime);
        
        List<Integer> dpEndTime = new ArrayList<>();
        List<Integer> dpProfit = new ArrayList<>();
        dpEndTime.add(0);
        dpProfit.add(0);
        
        for(Job job:jobs){
            int prevIdx = largestSmaller(dpEndTime,job.startTime+1);
            
            int case1Profit = dpProfit.get(prevIdx)+job.profit;
            int case2Profit = dpProfit.get(dpProfit.size()-1);
            
            if(case1Profit>case2Profit){
                dpEndTime.add(job.endTime);
                dpProfit.add(case1Profit);
            }
            
        }
        
        return dpProfit.get(dpProfit.size()-1);
    }
    
    int largestSmaller(List<Integer> list,int val){
        int left=0,right=list.size()-1;
        int ans = right;
        
        while(left<=right){
             int mid = left+(right-left)/2;
             if(list.get(mid)<val){
                 ans = mid;
                 left=mid+1;
             }else
                 right=mid-1;
        }
        return ans;
    }
}