class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int T=0,B=matrix.length-1,L=0,R=matrix[0].length-1;
        int dir=0;
        List<Integer> list = new ArrayList<>();
        while(T<=B&&L<=R){
            
            if(dir==0){
                for(int col=L;col<=R;col++){
                    list.add(matrix[T][col]);
                }
                T++;
            }else if(dir==1){
                for(int row=T;row<=B;row++){
                    list.add(matrix[row][R]);
                }
                R--;
            }else if(dir==2){
                for(int col=R;col>=L;col--){
                    list.add(matrix[B][col]);
                }
                B--;
            }else{
                for(int row=B;row>=T;row--){
                    list.add(matrix[row][L]);
                }
                L++;
            }
            
            dir = (dir+1)%4;
        }
        
        return list;
    }
}