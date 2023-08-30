class Solution {
    public List<String> fizzBuzz(int n) {
        // modulo operation allowed
        List<String> list = new ArrayList<>();
        int count3=0,count5=0;
        
        for(int i=1;i<=n;i++){
            count3++;count5++;
            if(count3==3&&count5==5){
                list.add("FizzBuzz");
                count3=0;
                count5=0;
            }else if(count3==3){
                list.add("Fizz");
                count3=0;
            }else if(count5==5){
                list.add("Buzz");
                count5=0;
            }else{
                list.add(String.valueOf(i));
            }
        }

        return list;
    }
}