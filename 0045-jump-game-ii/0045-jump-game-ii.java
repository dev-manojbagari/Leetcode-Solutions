class Solution {
    public int jump(int[] nums) {
       if(nums.length<=1)
           return 0;
        int ladder = nums[0];
        int stairs = nums[0];
        int jump=1;
        for(int i=1;i<nums.length-1;i++){
            if(i+nums[i]>ladder){
                ladder = nums[i]+i;
            }
            stairs--;
            
            if(stairs==0){
                jump++;
                stairs = ladder-i;
            }
        }
        
        return jump;
        
    }
}   