// dp[end_time] = max profit can be obtained from time 0 to end_time

// induction rule
// for each job = [s, e, p], where s = start time, e = end time, p = profit,
// case 1: don't do this job  -> nothing changes, dp[end_time] = dp[previous end_time]
// case 2: do this job -> dp[end_time] = dp[previous end_time <= s that gives max profit] + p
//         find the max profit we can make before start time s (using binary search), so we can know the max profit we can make after doing this job
// Therefore,
// dp[end_time] = max( dp[previous end_time],  dp[previous end_time <= s that gives max profit] + p )

// base case
// dp[0] = 0 as we make profit = 0 at time = 0.

class Solution {
    class Job {
        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // first sort jobs by end_time to make it easy to process each job and fill DP table
        int n = profit.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (j1, j2) -> Integer.compare(j1.end, j2.end));
        List<Integer> dpEndTime = new ArrayList<>();
        List<Integer> dpProfit = new ArrayList<>();
        dpEndTime.add(0); // base case to avoid IndexOutBoundExp
        dpProfit.add(0);

        for (Job job : jobs) {
            int prevIdx = largestSmaller(dpEndTime, job.start + 1); // previous job can end at job.start, so we use "job.start + 1"
            int case2Profit = dpProfit.get(prevIdx) + job.profit;
            int case1Profit = dpProfit.get(dpProfit.size() - 1);
            
            if (case2Profit > case1Profit) {
                dpEndTime.add(job.end);
                dpProfit.add(case2Profit);
            }
        }

        return dpProfit.get(dpProfit.size() - 1);
    }

    // return the index of the largest element < target in the given list (assume there must exist one element < target)
    private int largestSmaller(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int ans = 0;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return list.get(right) < target ? right : left;
    }
}