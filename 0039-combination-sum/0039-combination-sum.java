class Solution {
    Set<String> set;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        char[] cmap = new char[41];
        set= new HashSet<>();
        combinationSum(candidates,target,list,new ArrayList<>(),cmap);;
        return list;
    }
    
    void combinationSum(int[] candidates,int target,List<List<Integer>> list,List<Integer> tempList,char[] cmap){
        if(target==0){
            String key = new String(cmap);
            if(!set.contains(key)){
                list.add(new ArrayList<>(tempList));
                set.add(key);
            }
            return;
        }
        
        
        
        for(int i=0;i<candidates.length;i++){
            if(target-candidates[i]>=0){
                tempList.add(candidates[i]);
                cmap[candidates[i]]++;
                combinationSum(candidates,target-candidates[i],list,tempList,cmap);
                cmap[candidates[i]]--;
                tempList.remove(tempList.size()-1);
            }
            
        }
        
        
        
    }
}