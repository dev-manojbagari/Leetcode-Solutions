class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int next=0;
        while(set.add(n)){
            while(n>0){
                int lastDigit = n%10;
                next += lastDigit*lastDigit;
                n= n/10;
            }
            
            if(next==1)
                return true;
            else{
                n=next;
                next=0;
            }
        }
        return false;
    }
}