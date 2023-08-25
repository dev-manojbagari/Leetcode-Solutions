class Solution {
    public int[] findOrder(int n, int[][] prereq) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());
        
        int inDeg[] = new int[n];
        
        for(int[] c:prereq){
            list.get(c[1]).add(c[0]);
            inDeg[c[0]]++;
        }
        
        List<Integer> res = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<inDeg.length;i++){
            if(inDeg[i]==0){
                q.offer(i);
                }
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int x:list.get(node)){
                inDeg[x]--;
                if(inDeg[x]==0){
                    q.offer(x);
                }
            }
            
        }
        
        return res.size()==n?res.stream().mapToInt(j->j).toArray():new int[0];
        
        
    }
}