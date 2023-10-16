class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(0,0,n,list,"");
        return list;
    }
    
    void generateParenthesis(int open,int close,int n,List<String> list,String str){
        if(open+close==2*n){
            list.add(str);
            return;
        }
        
        if(open<n)
            generateParenthesis(open+1,close,n,list,str+"(");
        if(close<open)
            generateParenthesis(open,close+1,n,list,str+")");
        
        
    }
    
}