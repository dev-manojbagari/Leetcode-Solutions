class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        
        for(int num:hand){
            treeMap.put(num,treeMap.getOrDefault(num,0)+1);
        }
        
        for(int key:treeMap.keySet()){
            int count = treeMap.get(key);
            treeMap.put(key,0);
            if(count>0){
                for(int i=1;i<groupSize;i++){
                    if(!treeMap.containsKey(key+i)||treeMap.get(key+i)<count)
                        return false;
                    treeMap.put(key+i,treeMap.getOrDefault(key+i,0)-count);
                }
            }
        }
        
        
        return true;
    }
}