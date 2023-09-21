class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,nums,list,new ArrayList<>(),target);
        return list;
    }
    
    void backtrack(int start,int[] nums,List<List<Integer>> list,List<Integer> tempList,int target){
        if(target<0||start==nums.length)
            return;
        
        if(target==0){
            list.add(new ArrayList<>(tempList));
            return;
        }
        
        backtrack(start+1,nums,list,tempList,target);
        
        tempList.add(nums[start]);
        backtrack(start,nums,list,tempList,target-nums[start]);
        tempList.remove(tempList.size()-1);
        
        }
    }
