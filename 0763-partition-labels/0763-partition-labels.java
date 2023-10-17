class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,int[]> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),new int[]{i,i});
            }else
                map.get(s.charAt(i))[1]=i;
        }
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            end = Math.max(end,map.get(s.charAt(i))[1]);
            if(i==end)
            {
                list.add(end-start+1);
                start=end+1;
            }
        }
        
        
        return list;        
    }
}