class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer majElem1 = null,majElem2=null;
        int count1 =0,count2=0;;
        for(Integer num:nums){
            if(num.equals(majElem1)){
                count1++;
            }else if(num.equals(majElem2)){
                count2++;
            }else {
                if(count1==0){
                    majElem1=num;
                    count1=1;
                }else if(count2==0){
                    majElem2=num;
                    count2=1;
                }else{
                count1--;
                count2--;
            }
          }
        }
        
        count1=0;count2=0;
        
        for(Integer num:nums){
            if(num.equals(majElem1)){
                count1++;
            }else if(num.equals(majElem2)){
                count2++;
            }
        }
        
        int n = nums.length;
        
        
        List<Integer> list = new ArrayList<>();
        if(count1>n/3)
            list.add(majElem1);
        if(count2>n/3)
            list.add(majElem2);
        return list;
    }
}