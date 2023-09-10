class Solution {
    public List<List<Integer>> subsets(int[] nums) {
     //   Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        
        for(int i = start; i < nums.length; i++){
            // Skip duplicates
       //     if(i > start && nums[i] == nums[i-1]) continue;
            
            tempList.add(nums[i]);
            backtrack(list, tempList, nums,i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
