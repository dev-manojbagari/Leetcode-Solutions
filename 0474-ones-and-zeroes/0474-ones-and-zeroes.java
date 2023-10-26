class Solution {
    public int findMaxForm(String[] strs, int mZeros, int nOnes) {
        List<String> list = new ArrayList<>();
        for(String str:strs){
            int zeroCount=0,oneCount=0;
            
            for(char c:str.toCharArray()){
                if(c=='0')
                    zeroCount++;
                else
                    oneCount++;
            }
            
            if(zeroCount<=mZeros&&oneCount<=nOnes){
                list.add(str);
            }
        }
        return findMaxForms(0,list,mZeros,nOnes,new Integer[list.size()][mZeros+1][nOnes+1]);
    }
    
    int findMaxForms(int index,List<String> list,int mZeros,int nOnes,Integer[][][] cache){
          if(index==list.size())
              return 0;
        
            if(cache[index][mZeros][nOnes]!=null)
                return cache[index][mZeros][nOnes];
        
            int exclude = findMaxForms(index+1,list,mZeros,nOnes,cache);
            int[] count = countZeroOne(list.get(index));
        
            int include=0;
            if(count[0]<=mZeros&&count[1]<=nOnes){
                include  = 1+findMaxForms(index+1,list,mZeros-count[0],nOnes-count[1],cache);     
            }
        
        return cache[index][mZeros][nOnes]= Math.max(include,exclude);
    }
    
    int[] countZeroOne(String str){
        int[] res = new int[2];
        
        for(char c:str.toCharArray()){
            if(c=='0')
                res[0]++;
            else
                res[1]++;
        }
        return res;
    }
    
}