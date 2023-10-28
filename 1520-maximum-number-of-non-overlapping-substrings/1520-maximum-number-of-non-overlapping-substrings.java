class Solution {
    class Pair{
        int start,end;
        Pair(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    public List<String> maxNumOfSubstrings(String s) {
        Map<Character,Pair> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),new Pair(i,i));
            else
                map.get(s.charAt(i)).end=i;
        }
        
        int prevEnd = -1;
        List<String> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            int start = map.get(s.charAt(i)).start;
            int end = map.get(s.charAt(i)).end;
            if(i==start){
                int curEnd = getEnd(start,end,s,map);
                if(curEnd==-1) continue;
                String subStr =  s.substring(start,curEnd+1);
                if(curEnd<=prevEnd){
                    list.set(list.size()-1,subStr);
                }else{
                    list.add(subStr);
                }
                prevEnd=curEnd;
            }
        }
        
        return list;
    }
    
    int getEnd(int start,int end,String s,Map<Character,Pair> map){
        for(int i=start;i<end;i++){
            if(map.get(s.charAt(i)).start<start)
                return -1;
            end = Math.max(end,map.get(s.charAt(i)).end);
        }
        
        return end;        
    }
}