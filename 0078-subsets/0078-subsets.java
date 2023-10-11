class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsets(0,nums,list,new ArrayList<>());
        return list;
    }
    
    void subsets(int index,int[] nums,List<List<Integer>> list,List<Integer> tempList){
            list.add(new ArrayList(tempList));
        
        for(int i=index;i<nums.length;i++){
            tempList.add(nums[i]);
            subsets(i+1,nums,list,tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}