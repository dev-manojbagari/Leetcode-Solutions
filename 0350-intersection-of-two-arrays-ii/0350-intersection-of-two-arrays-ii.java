class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num:nums1)
            map.put(num,map.getOrDefault(num,0)+1);
        List<Integer> list = new ArrayList<>();
        for(int num:nums2){
            if(map.containsKey(num)){
                list.add(num);
                if(map.get(num)==1)
                    map.remove(num);
                else
                    map.put(num,map.get(num)-1);
            }
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}