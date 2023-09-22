class Solution {
    Map<Pair<Integer,Integer>,Integer> map= new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(0,nums,target);
    }
    
    int findTargetSumWays(int i,int[] nums,int target){
        
        if(i==nums.length)
            return target==0?1:0;

        Pair<Integer,Integer> pair = new Pair<>(i,target);
        
        if(map.containsKey(pair))
            return map.get(pair);
        
        
        int total =0;
        
        total += findTargetSumWays(i+1,nums,target-nums[i]);
        total += findTargetSumWays(i+1,nums,target+nums[i]);
        
        map.put(pair,total);
        return total;
    }
}