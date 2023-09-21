class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
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
            if(target-nums[i]>=0){
                tempList.add(nums[i]);
                backtrack(i,nums,list,tempList,target-nums[i]);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}