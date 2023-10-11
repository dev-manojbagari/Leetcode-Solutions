class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute(0,nums,list);
        return list;
    }
    
    void permute(int index,int[] nums,List<List<Integer>> list){
        if(index==nums.length){
            list.add(Arrays.stream(nums).boxed().toList());
            return;
        }
        
        for(int i=index;i<nums.length;i++){
            swap(nums,index,i);
            permute(index+1,nums,list);
            swap(nums,i,index);
        }
    }
    
    void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    
}