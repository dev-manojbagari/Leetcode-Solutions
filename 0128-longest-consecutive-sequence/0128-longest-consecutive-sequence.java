class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums)
            set.add(num);
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int count = 1;
                int temp = nums[i]+1;
                while(set.contains(temp)){
                    temp++;
                    count++;
                }
                max = Math.max(max,count);
            }
        }
        
        return max;
    }
}