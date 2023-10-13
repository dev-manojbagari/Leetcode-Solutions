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
        
        StringBuilder sb = new StringBuilder();
        boolean allZero=true;
        for(int num:list){
            if(num!=0)
                allZero=false;
            sb.append(num);
        }
        
        return allZero?"0":sb.toString();
    }
}