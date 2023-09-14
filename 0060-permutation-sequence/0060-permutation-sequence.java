class Solution {
    String ans = "";
  public String getPermutation(int n, int k) {
    int fact[] = new int[]{1,1,2,6,24,120,720,5040,40320,362880};
    
    LinkedList<Integer> list = new LinkedList<Integer>();
    for(int i=1; i<=n; i++) list.add(i);
    solve(list,n,k,fact);
    return ans;
}

public void solve(LinkedList<Integer> list, int n, int k, int[] fact){
    if(n == 1){
        ans+=list.get(list.size() - 1);
        return;
    }
    int index = k/fact[n-1];

    if(k%fact[n-1] == 0) index--;

    ans+=Integer.toString(list.get(index));
    list.remove(index);
    k = k - fact[n-1]*index;

    solve(list,n-1,k,fact);
}
}