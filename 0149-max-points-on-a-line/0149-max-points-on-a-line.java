class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int max=0;
        Map<String,Integer> map;
        for(int i=0;i<n;i++){
            map = new HashMap<>();
            int curMax=0;
            for(int j=i+1;j<n;j++){
                int dx = points[j][0]-points[i][0];
                int dy = points[j][1]-points[i][1];
                int gcd = gcd(dx,dy);
                dx = dx/gcd;
                dy = dy/gcd;
                
                String key = dx+","+dy;
                map.put(key,map.getOrDefault(key,0)+1);
                curMax = Math.max(curMax,map.get(key));
                
            }
            max = Math.max(max,curMax+1);
        }
        
        return max;
    }
    
    int gcd(int a,int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    
}