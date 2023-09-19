class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        
        for(int i=0;i<Math.max(s1.length,s2.length);i++){
            Integer n1 = i>=s1.length?0:Integer.parseInt(s1[i]);
            Integer n2 = i>=s2.length?0:Integer.parseInt(s2[i]);
            if(n1==n2)
                continue;
            else
                return n1.compareTo(n2);
            
        }
        
        return 0;
    }
}