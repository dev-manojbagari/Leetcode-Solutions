class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int r = s1.length();
        int c = s2.length();
        int l = s3.length();
        
        if (r + c != l) {
            return false;
        }
        
        boolean[] dp = new boolean[c + 1];
        dp[0] = true;
        
        for (int j = 1; j <= c; j++) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        for (int i = 1; i <= r; i++) {
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            
            for (int j = 1; j <= c; j++) {
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i - 1 + j)) ||
                        (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i - 1 + j));
            }
        }
        
        return dp[c];
    }
}