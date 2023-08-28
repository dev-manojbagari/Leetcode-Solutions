class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num:nums1)
            map.put(num,map.getOrDefault(num,0)+1);
        
        List<Integer> list = new ArrayList<>();
        int count =0;
        for(int num:nums2){
            if(map.containsKey(num)){
                list.add(num);
                int freq = map.get(num);
                freq--;
                if(freq==0)
                    map.remove(num);
                else
                    map.put(num,freq);
            }
        }
        
        return list.stream().mapToInt(x->x).toArray();
        
    }
}