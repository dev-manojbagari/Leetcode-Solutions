class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String firstStr = strs[0];
        String lastStr = strs[strs.length-1];
        int i=0;
        for(;i<Math.min(firstStr.length(),lastStr.length());i++){
            if(firstStr.charAt(i)!=lastStr.charAt(i))
                break; 
        }
        
        return firstStr.substring(0,i);
    }
}