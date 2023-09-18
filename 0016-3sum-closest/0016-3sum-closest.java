class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);    
        int closestSum=0;
        for(int i=0;i<n;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int j = i+1;
            int k = n-1;
            
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                
                if(sum==target)
                    return sum;
                if(Math.abs(sum-target)<min){
                    min=Math.abs(sum-target);
                    closestSum=sum;
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