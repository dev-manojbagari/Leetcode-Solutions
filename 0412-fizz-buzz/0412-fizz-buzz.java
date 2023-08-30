class Solution {
    public List<String> fizzBuzz(int n) {
        // modulo operation allowed
        List<String> list = new ArrayList<>();
        
        Map<Integer,String> map = new HashMap<>();
        map.put(3,"Fizz");
        map.put(5,"Buzz");
        
        for(int i=1;i<=n;i++){
        String str = "";
            for(Integer num:map.keySet()){
                if(i%num==0)
                    str += map.get(num);
            }
            
            if(str=="")
                list.add(String.valueOf(i));
            else
                list.add(str);
        }
        return list;
    }
}