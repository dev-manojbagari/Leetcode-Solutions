class Solution {
    public int threeSumClosest(int[] nums, int target) {
          Arrays.sort(nums);
        int n= nums.length;
        List<List<Integer>> list = new ArrayList<>();
        int diff =Integer.MAX_VALUE;
        int closestSum=Integer.MAX_VALUE;
        for(int i=0;i<n-2;i++){
            
            int j = i+1;
            int k = n-1;
            
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                
                if(sum==target)
                    return sum;
                
                if(Math.abs(target-sum)<diff){
                    diff=Math.abs(target-sum);
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
