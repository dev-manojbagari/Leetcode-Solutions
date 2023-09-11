class Solution {
    public int findMaximumXOR(int[] nums) {
        int max=0,mask=0;
        
        for(int i=31;i>=0;i--){
            mask = mask|(1<<i);
            Set<Integer> set = new HashSet<>();
            for(int num:nums){
                set.add(num&mask);
            }
            
            int greedyTry = max|1<<i;
            
            for(int leftPartOfNum:set){
                if(set.contains(leftPartOfNum^greedyTry)){
                    max=greedyTry;
                    break;
                }
            }
        }
        
        return max;
        
    }
}