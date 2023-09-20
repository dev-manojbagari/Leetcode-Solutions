class Solution {
    public List<Integer> majorityElement(int[] nums) {
       Integer num1 = null;
        Integer num2 = null;
        int count1=0,count2=0;
        
        for(Integer num:nums){
            if(num.equals(num1)){
                count1++;
            }else if(num.equals(num2)){
                count2++;
            }else if(count1==0){
                num1=num;
                count1=1;
            }else if(count2==0){
                num2=num;
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }
        
        count1=0;count2=0;
        int n = nums.length;
        for(Integer num:nums){
            if(num.equals(num1))
                count1++;
            else if(num.equals(num2))
                count2++;
        }
        List<Integer> list = new ArrayList<>();
        if(count1>n/3)
            list.add(num1);
        if(count2>n/3)
            list.add(num2);
        
        return list;
    }
}