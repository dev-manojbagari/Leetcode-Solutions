class TimeMap {
    class Data{
        int timestamp;
        String key,value;
        Data(String key,String value,int timestamp){
            this.key=key;
            this.value=value;
            this.timestamp=timestamp;
        }
    }
    Map<String,List<Data>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,(k->new ArrayList<>())).add(new Data(key,value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        return lastSmallerOrEqual(map.get(key),timestamp);
    }
    
    String lastSmallerOrEqual(List<Data> list,int timestamp){
        int left=0,right=list.size()-1;
        String ans ="";
        while(left<=right){
            int mid = left+(right-left)/2;
            
            if(list.get(mid).timestamp<=timestamp){
                ans = list.get(mid).value;
                left=mid+1;
            }else
                right=mid-1;
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