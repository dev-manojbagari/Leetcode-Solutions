class Solution {
    public int titleToNumber(String str) {
        int power = 0;
        int n = str.length();
        int num=0;
        for(int i=n-1;i>=0;i--){
          num += Math.pow(26,power)*(str.charAt(i)-'A'+1);
          power++;
        }
        return num;
    }
}