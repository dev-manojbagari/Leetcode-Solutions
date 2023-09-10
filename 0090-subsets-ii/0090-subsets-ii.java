class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        subsets(0,nums,set,new ArrayList<>());
        
        return new ArrayList<>(set);
    }
    
    void subsets(int index,int[] nums,Set<List<Integer>> set,List<Integer> curList){
        
        if(index==nums.length)
        {
            set.add(new ArrayList<>(curList));
            return;
        }
            
        subsets(index+1,nums,set,curList);
        curList.add(nums[index]);
        subsets(index+1,nums,set,curList);
        curList.remove(curList.size()-1);
    }
}