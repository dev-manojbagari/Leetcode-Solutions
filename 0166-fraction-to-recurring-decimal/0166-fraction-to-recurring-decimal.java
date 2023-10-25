class Solution {
    public String fractionToDecimal(int nume, int deno) {
        String sign = nume<0&&deno>0||nume>0&&deno<0?"-":"";
        long numeL = Math.abs((long)nume);
        long denoL = Math.abs((long)deno);
        StringBuilder sb = new StringBuilder();
        sb.append(sign).append(numeL/denoL);
        if(numeL%denoL==0)
            return sb.toString();
        sb.append(".");
        long rem = numeL%denoL;
        Map<Long,Integer> map = new HashMap<>();
        
        while(rem>0){
            map.put(rem,sb.length());
            rem = rem*10;
            sb.append(rem/denoL);
            rem = rem%denoL;
            
            if(map.containsKey(rem)){
                sb.insert(map.get(rem),"(");
                sb.append(")");
                break;
            }
        }
        
        
        return sb.toString();        
    }
}