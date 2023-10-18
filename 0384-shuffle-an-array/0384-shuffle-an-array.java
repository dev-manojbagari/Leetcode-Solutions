class Solution {
    int[] origArray;
    Random random = new Random();
    int[] nums;
    public Solution(int[] nums) {
        this.nums=nums;
        origArray = nums.clone();
        
    }
    
    public int[] reset() {
        nums=origArray.clone();
        return nums;
    }
    
    public int[] shuffle() {
        for(int i=nums.length-1;i>=0;i--){
            int randomIndex = random.nextInt(i+1);
            int t = nums[i];
            nums[i]=nums[randomIndex];
            nums[randomIndex]=t;
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