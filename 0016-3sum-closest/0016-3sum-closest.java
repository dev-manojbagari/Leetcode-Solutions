class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        
            int closestSum = Integer.MAX_VALUE;
            int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i-1]==nums[i])
                continue;
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
               if(Math.abs(sum-target)<minDiff){
                    minDiff = Math.abs(sum-target);
                    closestSum = sum;
                }
                
                if(sum<target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return closestSum;
    }
}