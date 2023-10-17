class DetectSquares {
    int[][] count = new int[1001][1001];
    List<int[]> list = new ArrayList<>();
    public DetectSquares() {
        
    }
    
    public void add(int[] point) {
        if(count[point[0]][point[1]]==0)
            list.add(point);
        count[point[0]][point[1]]++;
    }
    
    public int count(int[] point) {
        int total=0;
        for(int[] p:list){
             if(p[0]==point[0]&&p[1]==point[1])
                 continue;
            if(Math.abs(p[0]-point[0])==Math.abs(p[1]-point[1])){
                total += count[point[0]][p[1]]*count[p[0]][point[1]]*count[p[0]][p[1]];
            }
        }
        return total;   
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */