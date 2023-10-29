class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        
        for(String str:strs){
            char[] charCount = new char[26];
            for(char c:str.toCharArray()){
                charCount[c-'a']++;
            }
            String key = new String(charCount);
            map.computeIfAbsent(key,(k->new ArrayList<>())).add(str);
        }
        
        List<List<String>> list = new ArrayList<>();
        for(String key:map.keySet()){
            list.add(map.get(key));
        }
        return list;
    }
}