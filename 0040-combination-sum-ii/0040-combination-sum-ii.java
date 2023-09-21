class Solution {
   public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,nums,list,new ArrayList<>(),target);
        return list;
    }
    
    void backtrack(int start,int[] nums,List<List<Integer>> list,List<Integer> tempList,int target){
        if(target==0){
            list.add(new ArrayList<>(tempList));
            return;
        }
        
        
        for(int i=start;i<nums.length;i++){
            if(i>start&&nums[i]==nums[i-1]) continue;
            if(target-nums[i]>=0){
                tempList.add(nums[i]);
                backtrack(i+1,nums,list,tempList,target-nums[i]);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}