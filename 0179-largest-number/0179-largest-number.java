class Solution {
    public String largestNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num:nums)
            list.add(num);
        Collections.sort(list,(a,b)->{
            String s1 = Integer.toString(a);
            String s2 = Integer.toString(b);
            return (s2+s1).compareTo(s1+s2);
        });
        
        if(list.get(0)==0)
            return "0";
        StringBuilder sb = new StringBuilder();
        for(int num:list){
            sb.append(num);
        }
        
        return sb.toString();
    }
}