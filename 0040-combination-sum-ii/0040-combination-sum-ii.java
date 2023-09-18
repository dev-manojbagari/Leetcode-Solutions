class Solution {
      public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        combinationSum(nums, target, 0, list, new ArrayList<>());
        return list;
    }
    
    void combinationSum(int[] nums, int target, int start, List<List<Integer>> list, List<Integer> tempList) {
        if(target == 0){
            list.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int i = start; i < nums.length; i++){
            if(i>start&&nums[i]==nums[i-1]) continue;
            if(target - nums[i] >= 0){
                tempList.add(nums[i]);
                combinationSum(nums, target - nums[i], i+1, list, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}