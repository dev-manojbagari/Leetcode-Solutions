class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target)
            return 0;
        Map<Integer,List<Integer>> stopMap = new HashMap<>();
        
        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                int curBus = i;
                int curStop = routes[i][j];
                if(!stopMap.containsKey(curStop))
                    stopMap.put(curStop,new ArrayList<>());
                
                    stopMap.get(curStop).add(curBus);
            }
        }
        
        if(!stopMap.containsKey(source)||!stopMap.containsKey(target))
            return -1;
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> busTaken = new HashSet<>();
        Set<Integer> stopTaken = new HashSet<>();
        
        q.offer(source);
        stopTaken.add(source);
        int busCount=0;
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curStop = q.poll();
            
                for(int bus:stopMap.get(curStop)){
                   if(busTaken.contains(bus))
                      continue;
                   busTaken.add(bus);
                
                   for(int nextStop :routes[bus]){
                        if(stopTaken.contains(nextStop))
                            continue;
                        if(nextStop==target)
                            return busCount+1;
                       stopTaken.add(nextStop);
                       q.offer(nextStop);
                  }
             }
        }
        busCount++;
    }
        
        
        return -1;
    }
}