class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i=0;i<nums.length;i++)
            strs[i] =nums[i]+"";
            
        Arrays.sort(strs,(a,b)->{
            return (b+a).compareTo(a+b);
        });
        
        if(strs[0].equals("0"))
            return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            sb.append(str);
        }
        
        return sb.toString();
    }
}