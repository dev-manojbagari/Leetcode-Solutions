class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!dq.isEmpty()&&dq.peekFirst()<i-k+1){
                dq.pollFirst();
            }
            
            while(!dq.isEmpty()&&nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i-k+1>=0)
                res[i-k+1]=nums[dq.peekFirst()];
        }
        
        return res;
    }
}