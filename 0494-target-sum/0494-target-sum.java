class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(0,0,nums,target,new HashMap<>());
    }
    
    int findTargetSumWays(int index,int curSum,int[] nums,int target,Map<String,Integer> map){
        if(index==nums.length)
            return curSum==target?1:0;
        
         int count=0;
        String key = index+","+curSum;
        if(map.containsKey(key))
            return map.get(key);
            
        
        count += findTargetSumWays(index+1,curSum+nums[index],nums,target,map);
        count+=  findTargetSumWays(index+1,curSum-nums[index],nums,target,map);
        map.put(key,count);
        
        return count;
        
    }
}