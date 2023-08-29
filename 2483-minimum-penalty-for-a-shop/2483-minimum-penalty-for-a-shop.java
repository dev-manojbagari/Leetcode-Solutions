class Solution {
    public int bestClosingTime(String c) {
        int penality = 0;
        int curMin = 0;
        int minDay = 0;
        for(int i=0;i<c.length();i++){
            char customerStatus = c.charAt(i);
            if(customerStatus=='Y')
                penality -= 1;
            else
                penality += 1;
            
            if(penality<curMin){
                curMin=penality;
                minDay =i+1;
            }
            
        }
        
        return minDay;
    }
    
}