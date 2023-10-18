class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for(int num=1;num<=n;num++){
            if(num%3==0&&num%5==0){
                list.add("FizzBuzz");
            }else if(num%3==0){
                list.add("Fizz");
            }else if(num%5==0){
                list.add("Buzz");
            }else{
                list.add(Integer.toString(num));
            }
        }
        
        return list;
    }
}