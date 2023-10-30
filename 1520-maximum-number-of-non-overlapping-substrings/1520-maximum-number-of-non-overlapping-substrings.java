class Solution {
    class Pair{
        int start,end;
        Pair(int start,int end){
            this.start=start;
            this.end =end;
        }
    }
    public List<String> maxNumOfSubstrings(String s) {
        List<String> list = new ArrayList<>();
        Map<Character,Pair> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!map.containsKey(c))
                map.put(c,new Pair(i,i));
            else
                map.get(c).end=i;
        }
        
        int prevEnd = -1;
        for(int i=0;i<s.length();i++){
            int start = map.get(s.charAt(i)).start;
            int end = map.get(s.charAt(i)).end;
            if(i==start){
                int curEnd = getEnd(s,start,end,map);
                if(curEnd==-1) continue;
                String subStr= s.substring(start,curEnd+1);
                if(curEnd<prevEnd){
                    list.set(list.size()-1,subStr);
                }else
                    list.add(subStr);
                
                prevEnd = curEnd;
            }
        }
        
        return list;
    }
    int getEnd(String s,int start,int end,Map<Character,Pair> map){
        for(int i=start;i<end;i++){
            if(map.get(s.charAt(i)).start<start)
                return -1;
            end = Math.max(end,map.get(s.charAt(i)).end);
        }
        
        return end;
    }
}