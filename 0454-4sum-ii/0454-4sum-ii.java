class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums1.length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map.put(nums1[i]+nums2[j],map.getOrDefault(nums1[i]+nums2[j],0)+1);
            }        
        }
        
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum = nums3[i]+nums4[j];
                if(map.containsKey(-sum)){
                    count += map.get(-sum);
                }
            
            }        
        }
        
        return count;
        
    }
}