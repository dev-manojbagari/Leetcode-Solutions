class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord))
            return 0;
        
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        set.remove(beginWord);
        int level=1;
        
        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i=0;i<levelSize;i++){
                String word = q.poll();
                char[] ca = word.toCharArray();
                for(int index=0;index<word.length();index++){
                    char temp = ca[index];
                    
                    for(char c='a';c<='z';c++){
                        ca[index]=c;
                        String newWord = new String(ca);
                        
                        if(set.contains(newWord)){
                            if(newWord.equals(endWord)){
                                return level+1;
                            }
                            
                            q.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    ca[index]=temp;
                }
            }
                level++;
        }
        return 0;
    }
}