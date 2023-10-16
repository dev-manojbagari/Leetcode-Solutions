class Solution {
    public String getPermutation(int n, int k) {
        int fact[] =  new int[]{1,1,2,6,24,120,720,5040,40320,362880};
      //  for(int i=0;i<=9;)
       //     fact[i]=fact(i);
        
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++)
            list.add(i);
        StringBuilder res = new StringBuilder();
        getPermutation(n,list,k,fact,res);
        return res.toString();
    }
    
    void getPermutation(int n,List<Integer> list,int k,int[] fact,StringBuilder res){
        if(n==1){
            res.append(list.get(list.size()-1));
            return;
        }
        int index= k/fact[n-1];
        
        if(k%fact[n-1]==0)
            index--;

        res.append(list.get(index));
        
        list.remove(index);
        
        k = k-(index*fact[n-1]);
        
        getPermutation(n-1,list,k,fact,res);
    }
    
    int fact(int n){
        if(n==0||n==1)
            return 1;
        
        return n*fact(n-1);
    }
}