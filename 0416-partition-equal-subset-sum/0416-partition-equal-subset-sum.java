class Solution {
    public boolean canPartition(int[] nums) {
        int arraySum = Arrays.stream(nums).sum();
        
        if(arraySum%2!=0)
            return false;
        
        return subsetSum(0,nums,arraySum/2,new Boolean[nums.length][arraySum/2+1]);
    }
    
    private boolean subsetSum(int index,int[] nums,int sum,Boolean[][] cache){
        if(sum==0)
            return true;
        if(sum<0)
            return false;
        if(index==nums.length)
            return sum==0;

        if(cache[index][sum]!=null)
            return cache[index][sum];
        
        return cache[index][sum] = subsetSum(index+1,nums,sum,cache)||subsetSum(index+1,nums,sum-nums[index],cache);
    }
}