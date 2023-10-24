class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        
        backtrack(0,nums,target,list,new ArrayList<>());
        return list;
    }
    
    void backtrack(int index,int[] nums,int target,List<List<Integer>> list,List<Integer> tempList){
        if(target==0){
            list.add(new ArrayList<>(tempList));
            return;
        }
        if(index==nums.length)
            return;
        
        for(int i=index;i<nums.length;i++){
            if(target-nums[i]>=0){
                tempList.add(nums[i]);
                backtrack(i,nums,target-nums[i],list,tempList);
                tempList.remove(tempList.size()-1);
            }
        }
    }
    
}