class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> list= new ArrayList<>();
        
        for(int[] building:buildings){
            list.add(new int[]{building[0],-building[2]});
            list.add(new int[]{building[1],building[2]});
        }
        
        list.sort((a,b)->{
            if(a[0]!=b[0])
                return a[0]-b[0];
            
            return a[1]-b[1];
        });
        
        
       List<List<Integer>> res = new ArrayList<>();
        
        TreeMap<Integer,Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        
        int prevHeight =0;
        
        for(int[] h :list){
            if(h[1]<0){
                treeMap.put(-h[1],treeMap.getOrDefault(-h[1],0)+1);
            }else{
                int count = treeMap.get(h[1])-1;
                if(count==0)
                    treeMap.remove(h[1]);
                else
                    treeMap.put(h[1],count);
            }
            
            int currHeight = treeMap.isEmpty()?0:treeMap.firstKey();
            
            if(currHeight!=prevHeight){
                res.add(Arrays.asList(h[0],currHeight));
                prevHeight=currHeight;
            }
        }
            
        return res;            
        }
    }
