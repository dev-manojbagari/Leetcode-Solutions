class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        partition(0,s,list,new ArrayList<>());
        
        return list;
    }
    
    void partition(int index,String s,List<List<String>> list,List<String> tempList){
        if(index==s.length()){
            list.add(new ArrayList<>(tempList));
            return;
        }
        
        
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s.substring(index,i+1))){
                tempList.add(s.substring(index,i+1));
                partition(i+1,s,list,tempList);
                tempList.remove(tempList.size()-1);
            }
        }
    }
    
    boolean isPalindrome(String s){
        int left=0,right=s.length()-1;
        
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}