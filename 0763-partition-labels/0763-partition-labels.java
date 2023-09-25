class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> lastOccurence = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            lastOccurence.put(s.charAt(i),i);    
        }

        int start=0,end=0;
        List<Integer> partitions = new ArrayList<>();
        
        for(int i=0;i<s.length();i++){
            end = Math.max(end,lastOccurence.get(s.charAt(i)));
            if(i==end){
                partitions.add(end-start+1);
                start = end+1;
            }
        }
        
    
    
        return partitions;
    
    }
}