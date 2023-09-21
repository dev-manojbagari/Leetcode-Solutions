class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        backtrack(0,nums,set,new ArrayList<>(),target);
        return new ArrayList<>(set);
    }
    
    void backtrack(int start,int[] nums,Set<List<Integer>> set,List<Integer> tempList,int target){
        if(target==0){
            List<Integer> temp = new ArrayList<>(tempList);
            Collections.sort(temp);
            set.add(new ArrayList<>(temp));
            return;
        }
        
        
        for(int i=start;i<nums.length;i++){
            if(target-nums[i]>=0){
                tempList.add(nums[i]);
                backtrack(start,nums,set,tempList,target-nums[i]);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}