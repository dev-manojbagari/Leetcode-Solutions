class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        for(int i=0;i<position.length;i++){
            map.put(target-position[i],speed[i]);    
        }
        
        int fleet=0;
        double slowestTimeToTarget = 0.0;
        
        for(int key : map.keySet()){
            int curDistance = key;
            int curSpeed= map.get(key);
            
            double timeToTarget = (curDistance*1.0)/curSpeed;
            
            if(timeToTarget>slowestTimeToTarget){
                fleet++;
                slowestTimeToTarget = timeToTarget;
            }
        }

        return fleet;
    }
}