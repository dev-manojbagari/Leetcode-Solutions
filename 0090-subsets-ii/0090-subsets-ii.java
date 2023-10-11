class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        subsets(0,nums,list,new ArrayList<>());
        return list;
    }
    
    void subsets(int index,int[] nums,List<List<Integer>> list,List<Integer> tempList){
            list.add(new ArrayList(tempList));
        
        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i-1]==nums[i])
                continue;
            tempList.add(nums[i]);
            subsets(i+1,nums,list,tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}