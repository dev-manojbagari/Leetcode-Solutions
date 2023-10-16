class Solution {
    class Data{
        int oneCount;
        int zeroCount;
        Data(int zeroCount,int oneCount){
            this.zeroCount=zeroCount;
            this.oneCount=oneCount;
        }
    }
    public int findMaxForm(String[] strs, int m, int n) {
        List<Data> list = new ArrayList<>();
        for(String str:strs){
            int count1=0,count0=0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='0')
                    count0++;
                else
                    count1++;
            }
            if(count0<=m&&count1<=n)
                list.add(new Data(count0,count1));
        }
        
        return findMaxForm(0,list,m,n,new Integer[list.size()][m+1][n+1]);
    }
    
    int findMaxForm(int index,List<Data> list,int maxZeros,int maxOnes,Integer[][][] dp){
        if(index==list.size()||(maxZeros==0&&maxOnes==0))
        {
            return 0;
        }
        
        if(dp[index][maxZeros][maxOnes]!=null)
            return dp[index][maxZeros][maxOnes];
        
        int zeroCount = list.get(index).zeroCount;
        int oneCount = list.get(index).oneCount;
        int ans =0;
        if(zeroCount>maxZeros||oneCount>maxOnes){
            return dp[index][maxZeros][maxOnes] =findMaxForm(index+1,list,maxZeros,maxOnes,dp);
        }
        
        int exclude = findMaxForm(index+1,list,maxZeros,maxOnes,dp);
        int include = 1+findMaxForm(index+1,list,maxZeros-zeroCount,maxOnes-oneCount,dp);
        
        return dp[index][maxZeros][maxOnes]=Math.max(exclude,include);
        
    }
}