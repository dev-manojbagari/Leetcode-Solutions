class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        s = s.replaceAll("IV","IIII").replaceAll("IX","VIIII");
        s=  s.replaceAll("XL","XXXX").replaceAll("XC","LXXXX");
        s=  s.replaceAll("CD","CCCC").replaceAll("CM","DCCCC");
        int num=0;
        
        for(char c:s.toCharArray()){
            num+=map.get(c);
        }
        return num;
    }
}