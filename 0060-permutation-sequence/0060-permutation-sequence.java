class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[10];
        for(int i=0;i<=9;i++)
            fact[i]=fact(i);
        
        List<Integer> list= new ArrayList<>();
        for(int i=1;i<=n;i++)
            list.add(i);
        StringBuilder sb = new StringBuilder();
        getPermutation(n,k,list,fact,sb);
        
        return sb.toString();
    }
    
    void getPermutation(int n,int k,List<Integer> list,int[] fact, StringBuilder sb){
        if(n==1){
            sb.append(list.get(list.size()-1));
            return;
        }
        int index = k/fact[n-1];
        
        if(k%fact[n-1]==0)
            index--;
        
        sb.append(list.get(index)+"");
        list.remove(index);
        
        k = k-index*fact[n-1];
        
        getPermutation(n-1,k,list,fact,sb);
    }
    
    
    
    
    
    int fact(int i){
        if(i==0)
            return 1;
        return i*fact(i-1);
    }
}