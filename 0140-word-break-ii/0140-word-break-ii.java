class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        wordBreak(0,s,set,res,new StringBuilder());
        return res;
    }
    
    private void wordBreak(int i,String s,Set<String> set,List<String> list,StringBuilder sb){
        if(i==s.length()){
            list.add(sb.toString());
            return;
        }
        
        for(int j=i;j<s.length();j++){
            if(set.contains(s.substring(i,j+1))){
                int len = sb.length();
                if(sb.length()==0){
                    sb.append(s.substring(i,j+1));
                }else{
                    sb.append(" "+s.substring(i,j+1));
                }
                
                wordBreak(j+1,s,set,list,sb);
                sb.setLength(len);
            }
        }
    }
}