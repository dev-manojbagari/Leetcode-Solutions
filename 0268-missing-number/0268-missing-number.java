class Solution {
    public int missingNumber(int[] nums) {
        int arraySum = 0;
        for(int num:nums)
            arraySum += num;
        int n = nums.length;
        
        return (n*(n+1))/2-arraySum;
        
    }
}