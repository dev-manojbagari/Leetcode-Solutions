class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return f(0,nums,target,new HashMap<String,Integer>());
    }
    
    int f(int index,int[] nums,int target,Map<String,Integer> map){

        if(index==nums.length)
            return target==0?1:0;

        String key = index+","+target;
        if(map.containsKey(key))
            return map.get(key);
        
        
        int ans = 0;
        ans += f(index+1,nums,target-nums[index],map);
        ans += f(index+1,nums,target+nums[index],map);
        map.put(key,ans);
        return ans;
    }
    
}