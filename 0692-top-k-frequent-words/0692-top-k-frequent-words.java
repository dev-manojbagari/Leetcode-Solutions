class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);    
        }
        
        PriorityQueue<Map.Entry<String,Integer>> minHeap  = new PriorityQueue<>((a,b)->{
            if(a.getValue()!=b.getValue())
                return a.getValue()-b.getValue();
            return b.getKey().compareTo(a.getKey());            
        });
        
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(minHeap.size()<k){
                minHeap.offer(entry);
            }else if(entry.getValue()>minHeap.peek().getValue()){
                minHeap.poll();
                minHeap.offer(entry);
            }else if(entry.getValue()==minHeap.peek().getValue()&&entry.getKey().compareTo(minHeap.peek().getKey())<0){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        
        List<String> list = new ArrayList<>();

        while(!minHeap.isEmpty())
            list.add(0,minHeap.poll().getKey());
        
        return list;
    }
}