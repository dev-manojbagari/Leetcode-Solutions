class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = nums[0]+nums[1]+nums[2];    
        for(int i=0;i<n;i++){
            int j= i+1;
            int k = n-1;
            
            while(j<k){
               int sum = nums[i]+nums[j]+nums[k];
               if(sum==target){
                    return target;          
               }
               if(Math.abs(target-sum)<Math.abs(target-min)){
                   min=sum;
               }
               if(sum<target){
                   j++;
               }else{
                   k--;
               } 
            }
        }
        
        return min;
    }
}