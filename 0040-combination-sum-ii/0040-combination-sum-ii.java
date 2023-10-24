class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
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
            if(i>index&&nums[i]==nums[i-1])
                continue;
            if(target-nums[i]>=0){
                tempList.add(nums[i]);
                backtrack(i+1,nums,target-nums[i],list,tempList);
                tempList.remove(tempList.size()-1);
            }
        }
    }
    
}