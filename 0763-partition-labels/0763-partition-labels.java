class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        
        int start=0,end=0;
        List<Integer> list= new ArrayList<>();
        for(int i=0;i<s.length();i++){
            end = Math.max(end,map.get(s.charAt(i)));
            if(i==end){
                list.add(end-start+1);
                start=end+1;
            }
        }
        
        return list;
    }
}