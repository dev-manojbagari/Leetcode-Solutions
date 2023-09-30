class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target)
            return 0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        for(int bus=0;bus<routes.length;bus++){
            for(int j=0;j<routes[bus].length;j++){
                int curStop = routes[bus][j];
                map.computeIfAbsent(curStop,(k->new ArrayList<>())).add(bus);    
            }
        }
        
        if(!map.containsKey(source)||!map.containsKey(target))
            return -1;
        
        Queue<Integer> q  = new LinkedList<>();
        Set<Integer> busTaken = new HashSet<>();
        Set<Integer> stopTaken = new HashSet<>();
        q.offer(source);
        stopTaken.add(source);
        int buses =0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int curStop = q.poll();
                for(int bus:map.get(curStop)){
                    if(busTaken.contains(bus)) continue;
                    busTaken.add(bus);
                    for(int stop:routes[bus]){
                        if(stop==target)
                            return buses+1;
                        if(stopTaken.contains(stop)) continue;
                        stopTaken.add(stop);
                        q.offer(stop);
                    }
                }                
            }
            buses++;
        }
        
        return -1;
    }
}