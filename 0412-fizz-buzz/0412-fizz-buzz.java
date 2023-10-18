class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        int count3=3,count5=5;
        for(int num=1;num<=n;num++){
            count3--;
            count5--;
            if(count3==0&&count5==0){
                list.add("FizzBuzz");
                count3=3;
                count5=5;
            }else if(count3==0){
                 list.add("Fizz");
                 count3=3;
            }else if(count5==0){
                 list.add("Buzz");
                count5=5;
            }else{
                 list.add(Integer.toString(num));
            }
            
        }
        
        return list;
    }
}