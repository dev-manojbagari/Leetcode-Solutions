class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num:hand){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        for(int key:map.keySet()){
            if(map.get(key)>0){
                int count = map.get(key);
                map.put(key,0);
                for(int j=1;j<groupSize;j++){
                    if(!map.containsKey(key+j)||map.get(key+j)<count)
                        return false;
                    map.put(key+j,map.get(key+j)-count);
                }
            }
        }
            return true;
    }
}