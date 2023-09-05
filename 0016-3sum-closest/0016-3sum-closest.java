class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = nums[0]+nums[1]+nums[2];    
        for(int i=0;i<n;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
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
                   while(j<k&&nums[j-1]==nums[j])
                       j++;
                   
               }else{
                   k--;
                   while(j<k&&nums[k+1]==nums[k])
                       k--;
               } 
            }
        }
        
        return min;
    }
}