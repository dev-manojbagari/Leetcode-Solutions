class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while(set.add(n)){
            int next=0;
            while(n>0){
                int lastDigit = n%10;
                next += lastDigit*lastDigit;
                n= n/10;
            }
            
            if(next==1)
                return true;
            else{
                n=next;
            }
        }
        return false;
    }
}