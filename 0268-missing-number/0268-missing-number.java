class Solution {
    public int missingNumber(int[] nums) {
        int arraySum =0;
        arraySum=Arrays.stream(nums).sum();
        int n = nums.length;
        return (n*(n+1)/2)-arraySum;
    }
}