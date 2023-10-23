class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] newArr = new int[cuts.length+2];
        
        newArr[0]=0;
        newArr[newArr.length-1]=n;
        int index=1;
        for(int num:cuts)
            newArr[index++]=num;
        
        return minCost(1,newArr.length-2,newArr,new Integer[cuts.length+1][cuts.length+1]);
    }
    
    int minCost(int i,int j,int[] arr,Integer[][] state){
          if(i>j)
            return 0;
        int cost = Integer.MAX_VALUE;
        
        if(state[i][j]!=null)
            return state[i][j];
        
        for(int k=i;k<=j;k++)
            cost =  Math.min(cost,minCost(i,k-1,arr,state)+minCost(k+1,j,arr,state)+arr[j+1]-arr[i-1]);
        
        
        return state[i][j]=cost;
        
    }
    
    
    
}