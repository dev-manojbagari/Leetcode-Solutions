class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        
        combinationSumUtil(0,candidates,target,list,new ArrayList<>());
        
        return list;
    }
    
    void combinationSumUtil(int index,int[] candidates,int target,List<List<Integer>> list,List<Integer> tempList){
        if(index>=candidates.length)
            return;
        
        if(target==0){
            list.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int i=index;i<candidates.length;i++){
            if(target-candidates[i]>=0){
                tempList.add(candidates[i]);
                combinationSumUtil(i,candidates,target-candidates[i],list,tempList);
                tempList.remove(tempList.size()-1);
            }            
        }
        
    }
}