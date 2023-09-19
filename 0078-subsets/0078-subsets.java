class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsets(0,nums,list,new ArrayList<>());    
        return list;
    }
    
    private void subsets(int index,int[] nums,List<List<Integer>> list, List<Integer> tempList){
        if(index==nums.length){
            list.add(new ArrayList<>(tempList));
            return ;
        }
        
            
        
        
            subsets(index+1,nums,list,tempList);
        
            tempList.add(nums[index]);
            subsets(index+1,nums,list,tempList);
            tempList.remove(tempList.size()-1);
        
        
    }
}