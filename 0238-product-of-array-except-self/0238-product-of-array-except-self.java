class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int right = 1;
        res[0]=1;
        
        for(int i=1;i<n;i++){
            res[i] = res[i-1]*nums[i-1];
        }
  
        System.out.println(Arrays.toString(res));
        
        int left =1;
        for(int i=n-1;i>=0;i--){
            res[i]= res[i]*left;
            left = left*nums[i];
        }
       
        System.out.println(Arrays.toString(res));
        
        return res;
    }
}