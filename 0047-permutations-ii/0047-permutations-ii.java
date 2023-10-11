class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        permute(0,new boolean[nums.length],nums,new ArrayList<>(),list);
        return list;
    }
    
    void permute(int index,boolean[] used,int[] nums,List<Integer> cur,List<List<Integer>> list){
        if(index==nums.length){
            list.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            // Skip if the number is used or it's identical to its previous neighbor and its previous neighbor is unused.
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1])
                continue;
            
            cur.add(nums[i]);
            used[i] = true;
            permute(index+1,used,nums,cur,list);
            
            // Backtrack
            cur.remove(cur.size() - 1);
            used[i] = false;  
        }
    } 
}
