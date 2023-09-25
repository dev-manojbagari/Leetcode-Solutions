class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        
        for(int num:hand)
            treeMap.put(num,treeMap.getOrDefault(num,0)+1);
        
        for(int card:treeMap.keySet()){
            if(treeMap.get(card)>0){
                int count= treeMap.get(card);
                treeMap.put(card,0);
                for(int i=1;i<groupSize;i++){
                    if(treeMap.getOrDefault(card+i,0)<count)
                        return false;
                    treeMap.put(card+i,treeMap.get(card+i)-count);
                }
            }
            
        }
        
        return true;
    }
}