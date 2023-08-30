class Solution {
    public List<String> fizzBuzz(int n) {
        // modulo operation allowed
        List<String> list = new ArrayList<>();
        
        Map<Integer,String> map = new HashMap<>();
        map.put(3,"Fizz");
        map.put(5,"Buzz");
        
        for(int i=1;i<=n;i++){
            StringBuilder sb = new StringBuilder();
            for(Integer num:map.keySet()){
                if(i%num==0)
                    sb.append(map.get(num));
            }
            
            if(sb.length()==0)
                list.add(String.valueOf(i));
            else
                list.add(sb.toString());
        }
        return list;
    }
}