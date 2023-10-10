class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
         Set<Integer> set = new HashSet(wordDict);
         List<String> list = new ArrayList<>();
         wordBreak(0,s,wordDict,set,list,new StringBuilder());
        
        return list;
    }
    
    void wordBreak(int index,String s,List<String> wordDict,Set<Integer> set,List<String> list,StringBuilder sb){
        if(index==s.length()){
            list.add(sb.toString());
            return;
        }

        for(int i=index;i<s.length();i++){
            if(set.contains(s.substring(index,i+1))){
                int len = sb.length();
                if(len==0)
                    sb.append(s.substring(index,i+1));
                else
                    sb.append(" "+s.substring(index,i+1));
                wordBreak(i+1,s,wordDict,set,list,sb);
                sb.setLength(len);
            }
        }
        
    }
}