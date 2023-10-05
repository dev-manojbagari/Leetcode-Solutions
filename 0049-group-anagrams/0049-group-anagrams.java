class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();        
        for(String str:strs){
           char[] cmap = new char[26];
            for(char c:str.toCharArray()){
                cmap[c-'a']++;
            }
            String key = new String(cmap);
            map.computeIfAbsent(key,(k->new ArrayList<>())).add(str);
        }

        res.addAll(map.values());
        return res;
    }
}