class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        return findMaxForm(0,strs,m,n,new Integer[strs.length+1][m+1][n+1]);
    }
    
    int findMaxForm(int i,String[] strs,int zeroCount,int oneCount,Integer[][][] dp){
        if(i==strs.length||(zeroCount==0&&oneCount==0))
            return 0;
        
        if(dp[i][zeroCount][oneCount]!=null)
            return dp[i][zeroCount][oneCount];
        
        int[] count = countZeroOne(strs[i]);
        
        int ans =0;
        int notInclude = findMaxForm(i+1,strs,zeroCount,oneCount,dp);
        int include=0;
        if(zeroCount>=count[0]&&oneCount>=count[1]){
                
            include = 1+ findMaxForm(i+1,strs,zeroCount-count[0],oneCount-count[1],dp);
        }
        
        
        return dp[i][zeroCount][oneCount]=Math.max(include,notInclude);
    }
    
    
    int[] countZeroOne(String str){
        int zero=0,one=0;
        for(char c:str.toCharArray()){
            if(c=='0')
                zero++;
            else
                one++;
        }
        return new int[]{zero,one};
    }
    
}