class Solution {
 public int combinationSum4(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
      //  Arrays.sort(nums);
       int count= backtrack(0,nums,list,new ArrayList<>(),target,new Integer[target+1]);
        return count;
    }
    
    int backtrack(int start,int[] nums,List<List<Integer>> list,List<Integer> tempList,int target,Integer[] dp ){
        if(target==0){
            return 1;
        }
        
        if(dp[target]!=null)
            return dp[target];
        
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(target-nums[i]>=0){
               count += backtrack(i,nums,list,tempList,target-nums[i],dp);
            }
        }
        
        return dp[target] = count;
    }
    
}