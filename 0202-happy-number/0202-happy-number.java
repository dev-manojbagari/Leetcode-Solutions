class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int temp=0;
        while(set.add(n)){
            while(n>0){
            int lastDigit = n%10;
            temp += lastDigit*lastDigit;
            n=n/10;
            }
            if(temp==1){
                return true;
            }
            n = temp;
            temp = 0;
        }
        
        return false;
    }
}