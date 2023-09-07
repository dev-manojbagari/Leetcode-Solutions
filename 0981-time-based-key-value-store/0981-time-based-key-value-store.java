class TimeMap {
    class Data{
        String value;
        int timestamp;
        Data(String value,int timestamp){
            this.value=value;
            this.timestamp=timestamp;
        }
    }
    
    Map<String,List<Data>> map = new HashMap<>();
    
    public TimeMap() {
            
    }
    
    public void set(String key, String value, int timestamp) {
     map.computeIfAbsent(key,k->new ArrayList<Data>()).add(new Data(value,timestamp));   
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        else if(map.get(key).size()==1)
            return map.get(key).get(0).value;
        else
            return ceiling(map.get(key),timestamp);
    }
    
    private String ceiling(List<Data> list,int timestamp){
        
        int left = 0,right=list.size()-1;
        String ans ="";
        while(left<=right){
           int mid = left+(right-left)/2;
            
           if(list.get(mid).timestamp<=timestamp){
              ans = list.get(mid).value;
              left=mid+1;
           }else{
               right=mid-1;
           }
        }
        
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */