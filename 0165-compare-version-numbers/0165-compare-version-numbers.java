class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        
        int length = Math.max(s1.length,s2.length);
        
        for(int i=0;i<length;i++){
            Integer n1 = i>=s1.length?0:Integer.parseInt(s1[i]);
            Integer n2 = i>=s2.length?0:Integer.parseInt(s2[i]);
            int compare = n1.compareTo(n2);
            if(compare!=0)
                return compare;
            
        }
        
        
        return 0;
    }
}