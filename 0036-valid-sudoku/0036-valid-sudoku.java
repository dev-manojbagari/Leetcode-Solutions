class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    char c = board[i][j];
                    if(!set.add(c +" in row "+i)||
                       !set.add(c+" in col "+j)||
                       !set.add(c+" in block "+i/3+","+j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}