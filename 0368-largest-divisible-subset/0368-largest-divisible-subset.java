class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] L = new int[n];
        int[] P = new int[n];
        Arrays.fill(P,-1);
        int maxLen=0,maxIndex=0;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(L[j]+1>L[i]){
                        L[i]=1+L[j];
                        P[i]=j;
                    }
                }
            }
            if(maxLen<L[i]){
                maxLen = L[i];
                maxIndex=i;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        int index=maxIndex;
        while(index!=-1){
            list.add(nums[index]);
            index=P[index];
        }
        return list;
    }
}