class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        Map<Character,int[]> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!map.containsKey(c))
                map.put(c,new int[]{i,i});
            else
                map.get(c)[1]=i;
        }
        
        List<String> res = new ArrayList<>();
        int prevEnd = -1;
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(map.get(c)[0]==i){
                int end = getEndTime(c,s,map);
                if(end==-1) continue;
                if(prevEnd<i)
                    res.add("");
                
                res.set(res.size()-1,s.substring(i,end+1));
                prevEnd=end;
            }
            
            
            
        }
            return res;            
    }
    
    int getEndTime(char c,String s,Map<Character,int[]> map){
        int start = map.get(c)[0],end = map.get(c)[1];
        for(int i=start;i<=end;i++){
            int curStart = map.get(s.charAt(i))[0];
            if(curStart<start)
                return -1;
             int curEnd = map.get(s.charAt(i))[1];
            if(curEnd>end)
                end = curEnd;
        }
        
        return end;
    }
}