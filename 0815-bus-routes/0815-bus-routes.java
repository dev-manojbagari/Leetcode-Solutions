class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target)
            return 0;
        Map<Integer,List<Integer>> stopMap = new HashMap<>();
        
        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                if(!stopMap.containsKey(routes[i][j]))
                    stopMap.put(routes[i][j],new ArrayList<>());
                stopMap.get(routes[i][j]).add(i);
            }
        }
        
        if(!stopMap.containsKey(source)||!stopMap.containsKey(target))
            return -1;
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> stopTaken = new HashSet<>();
        Set<Integer> busTaken = new HashSet<>();
        q.offer(source);
        stopTaken.add(source);
        int busCount = 0;
        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i=0;i<levelSize;i++){
                int curStop = q.poll();
                for(int bus:stopMap.get(curStop)){
                    if(busTaken.contains(bus)){
                        continue;
                    }
                    busTaken.add(bus);
                    for(int nextStop:routes[bus]){
                        if(stopTaken.contains(nextStop)){
                            continue;
                        }
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