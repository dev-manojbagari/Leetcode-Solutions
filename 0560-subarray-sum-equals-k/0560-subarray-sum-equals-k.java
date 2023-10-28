class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int curSum=0;
        int count=0;
        
        for(int num:nums){
            curSum += num;
            if(map.containsKey(curSum-k))
                count += map.get(curSum-k);
            map.put(curSum,map.getOrDefault(curSum,0)+1);
        }
        
        return count;
    }
}