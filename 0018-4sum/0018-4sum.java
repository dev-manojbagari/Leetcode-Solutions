class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        int n= nums.length;
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
           // if (j > i + 1 && nums[j] == nums[j - 1]) continue;
               int k = j+1;
               int l = n-1;
                
               while(k<l){
                   long sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                   if(sum==target){
                       res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[l])));
                       k++;
                       l--;
                   }else if(sum<target){
                       k++;
                   }else{
                       l--;
                   }
                       
               }
                
            }
        }

        
        return new ArrayList<>(res);
    }
}