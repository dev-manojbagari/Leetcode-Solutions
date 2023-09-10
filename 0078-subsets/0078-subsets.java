class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsets(0,nums,list,new ArrayList<>());
        
        return list;
    }
    
    void subsets(int index,int[] nums,List<List<Integer>> list,List<Integer> curList){
        
        if(index==nums.length)
        {
            list.add(new ArrayList<>(curList));
            return;
        }
            
        subsets(index+1,nums,list,curList);
        curList.add(nums[index]);
        subsets(index+1,nums,list,curList);
        curList.remove(curList.size()-1);
    }
}