class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<words.length;i++)
            map.put(words[i],i);
        
        if(map.containsKey("")){
            int index = map.get("");
            for(int i=0;i<words.length;i++){
                if(isPalindrome(words[i])){
                    if(i==index) continue;
                    res.add(Arrays.asList(index,i));
                    res.add(Arrays.asList(i,index));
                }
            }
        }
           
            for(int i=0;i<words.length;i++){
                String word = words[i];
                String reverse = new StringBuilder(word).reverse().toString();
                if(map.containsKey(reverse)){
                    if(map.get(reverse)==i)
                        continue;
                    res.add(Arrays.asList(i,map.get(reverse)));
                }
            }
           
            for(int i=0;i<words.length;i++){
                String word = words[i];
                for(int cut=1;cut<word.length();cut++){
                    if(isPalindrome(word.substring(0,cut))){
                        String cut_reverse =new StringBuilder(word.substring(cut)).reverse().toString(); 
                        if(map.containsKey(cut_reverse)){
                            if(map.get(cut_reverse)==i) continue;
                            res.add(Arrays.asList(map.get(cut_reverse),i));
                        }
                    }  
                    
                      if(isPalindrome(word.substring(cut))){
                        String cut_reverse = new StringBuilder(word.substring(0,cut)).reverse().toString();
                        if(map.containsKey(cut_reverse)){
                            if(map.get(cut_reverse)==i) continue;
                            res.add(Arrays.asList(i,map.get(cut_reverse)));
                        }
                    } 
                    
                    
                    
                    
                }
            }
        
        
        return res;
    }
    
    boolean isPalindrome(String str){
        int i=0,j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
     return true;
    }
    
}