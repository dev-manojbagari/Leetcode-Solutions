class Solution {
    public String countAndSay(int n) {
        StringBuilder curr = new StringBuilder();
        curr.append("1");
        if(n==1)
            return curr.toString();
        StringBuilder next = new StringBuilder();
        
        for(int i=2;i<=n;i++){
            char prev = curr.charAt(0);
            int count=1;
            for(int j=1;j<curr.length();j++){
                if(curr.charAt(j)==prev){
                    count++;
                }else{
                    next.append(count).append(prev);
                    prev=curr.charAt(j);
                    count=1;
                }
            }    
                
            next.append(count).append(prev);  
            curr=next;
            next=new StringBuilder();
        }
    return curr.toString();               
    }
                   
}