class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            for(int l=i+1;l<nums.length;l++){
                if(l>i+1&&nums[l-1]==nums[l])
                    continue;
                
            int j = l+1;
            int k = nums.length-1;
            while(j<k){
                long sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                if(sum==(long)target){
                    list.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                    j++;
                    while(j<k&&nums[j]==nums[j-1])
                        j++;
                    k--;
                    while(j<k&&nums[k]==nums[k+1])
                        k--;
                }else if(sum<target){
                    j++;
                }else{
                    k--;
                }
            }
          }
        }
        
        return list;
    }
}