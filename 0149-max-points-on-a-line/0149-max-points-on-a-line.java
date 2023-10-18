class Solution {
    public int maxPoints(int[][] points) {
        int max=0;
        for(int i=0;i<points.length;i++){
            int curMax=0;
            Map<String,Integer> map = new HashMap<>();
            for(int j=i+1;j<points.length;j++){
                int dx = points[j][0]-points[i][0];
                int dy = points[j][1]-points[i][1];
                int gcd = gcd(dx,dy);
                dx = dx/gcd;
                dy = dy/gcd;
                
                String key = dx+","+dy;
                
                map.put(key,map.getOrDefault(key,0)+1);
                
                int count = map.get(key);
                if(count>curMax)
                    curMax=count;
            }
            
            if(max<curMax+1)
                max=curMax+1;
        }
        
        return max;
    }
    
    
    int gcd(int a,int b){
        if(b==0)
            return a;
        
        return gcd(b,a%b);
    }
}