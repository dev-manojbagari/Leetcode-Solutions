class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        List<String> res = new ArrayList<>();
        
        Map<Character,int[]> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),new int[]{i,i});
            else
                map.get(s.charAt(i))[1]=i;
        }
        
        int prevEnd= -1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int start = map.get(c)[0];
            int end = map.get(c)[1];
            if(start==i){
                int curEnd = getEnd(start,end,s,map);
                if(curEnd!=-1){
                    if(curEnd<=prevEnd){
                        res.set(res.size()-1,s.substring(start,curEnd+1));
                    }else
                        res.add(s.substring(start,curEnd+1));
                    prevEnd= curEnd;
                }
            }
        }
        
        return res;
    }
    int getEnd(int start,int end ,String str,Map<Character,int[]> map){
        for(int i=start;i<=end;i++){
            if(map.get(str.charAt(i))[0]<start){
                return -1;
            }
            end = Math.max(end,map.get(str.charAt(i))[1]);
        }
        return end;
    }
}