class Solution {
    int[] origArray;
    int[] nums;
    Random random;
    public Solution(int[] nums) {
        origArray = nums.clone();
        this.nums=nums;
        random = new Random();
    }
    
    public int[] reset() {
        nums = origArray.clone();
        return nums;
    }
    
    public int[] shuffle() {
        for(int i=0;i<nums.length;i++){
            int randomIndex = random.nextInt(i+1);
            int temp = nums[randomIndex];
            nums[randomIndex] =nums[i];
            nums[i]=temp;
        }
        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */