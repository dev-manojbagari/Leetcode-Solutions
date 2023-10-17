class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
     TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for(int i=0;i<position.length;i++){
            treeMap.put(target-position[i],speed[i]);
        }
        
        double maxTimeToTarget = 0;
        int fleet = 0;
        for(int key:treeMap.keySet()){
            int curDistance = key;
            int curSpeed = treeMap.get(key);
            double curTime = (curDistance*1.0)/curSpeed;
            if(curTime>maxTimeToTarget){
                maxTimeToTarget=curTime;
                fleet++;
            }
        }
        return fleet;        
    }
}