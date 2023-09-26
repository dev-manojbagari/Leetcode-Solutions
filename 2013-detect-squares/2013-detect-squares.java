class DetectSquares {
    int[][] count = new int[1001][1001];
    List<int[]> list = new ArrayList<>();
    public DetectSquares() {
        
    }
    
    public void add(int[] point) {
        if(count[point[0]][point[1]]==0){
            list.add(point);
        }
        
        count[point[0]][point[1]]++;
    }
    
    public int count(int[] point) {
        int c =0;
        
        for(int[] curPoint:list){
            if(curPoint[0]==point[0]&&curPoint[1]==point[1])
                continue;
                        
            if(Math.abs(curPoint[0]-point[0])==Math.abs(curPoint[1]-point[1]))
                c += count[curPoint[0]][point[1]]*count[point[0]][curPoint[1]]*count[curPoint[0]][curPoint[1]];
            
        }
        
        
        return c;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */