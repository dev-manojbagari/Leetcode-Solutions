class Solution {
    String str = "";
    public String getPermutation(int n, int k) {
        int fact[] = new int[]{1,1,2,6,24,120,720,5040,40320,362880};
        LinkedList list = new LinkedList<>();
        for(int i=1;i<=n;i++)
            list.add(i);
        
        getPermutation(n,k,fact,list);
        return str;
    }
    
    void getPermutation(int n,int k,int[] fact,LinkedList<Integer> list){
        if(n==1)
        {
            str += list.get(list.size()-1);
            return;
        }
        
        int index = k/fact[n-1];
        
        if(k%fact[n-1]==0)
            index--;
        
        str += Integer.toString(list.get(index));
        list.remove(index);
        k = k-index*fact[n-1];
        getPermutation(n-1,k,fact,list);
    }
}