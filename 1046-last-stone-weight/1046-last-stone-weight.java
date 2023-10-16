class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        for(int stone:stones)
            pq.offer(stone);
        
        while(pq.size()>1){
            int max1 = pq.poll();
            int max2 = pq.poll();
            if(max1!=max2)
                pq.offer(Math.abs(max1-max2));
        }
        
        return pq.isEmpty()?0:pq.peek();        
        
    }
}