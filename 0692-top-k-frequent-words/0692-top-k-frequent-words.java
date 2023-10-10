class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        
        for(String word:words)
            map.put(word,map.getOrDefault(word,0)+1);
        
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b)->{
            
            if(a.getValue().equals(b.getValue())){
                return b.getKey().compareTo(a.getKey());
            }else
                return Integer.compare(a.getValue(),b.getValue());
        });
        
        for(Map.Entry<String,Integer> entry :map.entrySet()){
            if(pq.size()<k){
                pq.offer(entry);
            }else if(entry.getValue()>pq.peek().getValue()){
                pq.poll();
                pq.offer(entry);
            }else if(entry.getValue()==pq.peek().getValue()&&entry.getKey().compareTo(pq.peek().getKey())<0){
                pq.poll();
                pq.offer(entry);
            }
        }
        
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(0,pq.poll().getKey());
        }
        return res;
    }
}