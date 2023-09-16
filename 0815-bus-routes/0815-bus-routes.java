class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int k = 0; k < routes.length; k++) {
            int[] route = routes[k];
            int n = route.length;
            for (int i = 0; i < n; i++) {
                int stop = route[i];
                if (!graph.containsKey(stop)) {
                    graph.put(stop, new ArrayList<>());
                }
                graph.get(stop).add(k);
            }
        }
        
        if (!graph.containsKey(S) || !graph.containsKey(T)) return -1;
        if (S == T) return 0;
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> busTaken = new HashSet<>();
        Set<Integer> stopVisited = new HashSet<>();
        
        q.add(S);
        
        int cnt = 0;
        
        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curStop = q.poll();
                for (int bus : graph.get(curStop)) {
                    if (busTaken.contains(bus)) continue; //not take the same bus again...
                    busTaken.add(bus);
                    for (int nextStop : routes[bus]) {
                        if (stopVisited.contains(nextStop)) { continue; } //not visited the same stop...
                        if (nextStop == T) { return cnt; }
                        q.add(nextStop);
                        stopVisited.add(nextStop);
                    }
                }
            }
        }
        return -1;
    }
}