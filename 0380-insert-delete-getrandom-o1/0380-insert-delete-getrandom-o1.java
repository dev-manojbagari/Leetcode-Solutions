class RandomizedSet {
    Map<Integer,Integer> map;
    List<Integer> list;
    Random random = new Random();
    public RandomizedSet() {
        map = new HashMap<>();
        list= new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int idx = map.get(val);
        int lastVal = list.get(list.size()-1);
        list.set(idx,lastVal);
        map.put(lastVal,idx);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIdx = random.nextInt(list.size());
        return list.get(randomIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */