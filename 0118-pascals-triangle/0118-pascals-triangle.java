class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            list.add(new ArrayList<>());
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    list.get(i).add(1);
                }else{
                    int a = list.get(i-1).get(j-1);
                    int b = list.get(i-1).get(j);
                    list.get(i).add(a+b);
                }
            }
        }
        
        return list;
    }
}