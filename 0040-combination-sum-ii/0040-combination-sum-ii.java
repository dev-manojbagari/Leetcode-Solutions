class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumUtil(0,candidates,target,list,new ArrayList<>());
        
        return list;
    }
    
    void combinationSumUtil(int index,int[] candidates,int target,List<List<Integer>> list,List<Integer> tempList){
        if(target==0){
            list.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int i=index;i<candidates.length;i++){
            if(i>index&&candidates[i-1]==candidates[i])
                continue;
            if(target-candidates[i]>=0){
                tempList.add(candidates[i]);
                combinationSumUtil(i+1,candidates,target-candidates[i],list,tempList);
                tempList.remove(tempList.size()-1);
            }            
        }
        
    }
}