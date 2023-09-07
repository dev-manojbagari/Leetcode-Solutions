class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        
        for(String word:words)
            map.put(word,map.getOrDefault(word,0)+1);
        
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b)->{
                                                                            if(a.getValue()!=b.getValue()){
                                                                                return a.getValue()-b.getValue();
                                                                            }
                                                                                return b.getKey().compareTo(a.getKey());
            
        });
        
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            
            if(pq.size()<k){
                pq.offer(entry);
            }else if(entry.getValue()>pq.peek().getValue()||entry.getValue()==pq.peek().getValue()&&
                    entry.getKey().compareTo(pq.peek().getKey())<0)  {
                pq.poll();
                pq.offer(entry);
            }
        }
        
    
            
        LinkedList<String> list = new LinkedList<>();
        
        while(!pq.isEmpty()){
            list.addFirst(pq.poll().getKey());            
        }
        
        return list;
        
    }
}