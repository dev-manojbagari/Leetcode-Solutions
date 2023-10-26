class Solution {
    public int majorityElement(int[] nums) {
        int majElem = nums[0];
        int count =1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==majElem){
                count++;
            }else{
                count--;
                if(count==0){
                    majElem =nums[i];
                    count=1;
                }
            }
        }
        
        return majElem;
    }
}