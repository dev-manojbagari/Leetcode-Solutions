class Solution {
    class Pair{
        int ones=0,zeros=0;
        Pair(int zeros,int ones){
            this.ones=ones;
            this.zeros=zeros;
        }
    }
    public int findMaxForm(String[] strs, int m, int n) {
        List<Pair> list = new  ArrayList<>();
        
        for(String str:strs){
            int oneCount=0,zeroCount=0;
            for(char c:str.toCharArray()){
                if(c=='0')
                    zeroCount++;
                else
                    oneCount++;
            }
            if(zeroCount<=m&&oneCount<=n)
            list.add(new Pair(zeroCount,oneCount));
        }
        Integer[][][] dp = new Integer[list.size()][m+1][n+1];
        return findMaxForm(0,list,m,n,dp);
    }

    private int findMaxForm(int index,List<Pair> list , int maxZeros,int maxOnes,Integer[][][] dp){
        
        if(index==list.size()||(maxZeros==0&&maxOnes==0))
            return 0;
        
        
        
        if(dp[index][maxZeros][maxOnes]!=null)
            return dp[index][maxZeros][maxOnes];
        
        int oneCount = list.get(index).ones;
        int zeroCount = list.get(index).zeros;
        
        if(oneCount>maxOnes||zeroCount>maxZeros){
            return dp[index][maxZeros][maxOnes]= findMaxForm(index+1,list,maxZeros,maxOnes,dp);
        }
        
        
        int notInclude = findMaxForm(index+1,list,maxZeros,maxOnes,dp);
        int include = 1+findMaxForm(index+1,list,maxZeros-zeroCount,maxOnes-oneCount,dp);
        
        return dp[index][maxZeros][maxOnes]= Math.max(notInclude,include);
    }
}