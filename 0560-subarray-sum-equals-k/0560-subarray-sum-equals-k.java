class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        
        int cummulativeSum=0;
        int count=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            cummulativeSum =cummulativeSum+nums[i];
            if(map.containsKey(cummulativeSum-k))
                count+=map.get(cummulativeSum-k);
            
            map.put(cummulativeSum,map.getOrDefault(cummulativeSum,0)+1);
        }
        
       return count;
        
        
    }
}