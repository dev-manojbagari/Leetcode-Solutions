class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord))
            return 0;
            
        Queue<String> q  = new LinkedList<>();
        q.offer(beginWord);
        set.remove(beginWord);
        int level=1;
            
        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i=0;i<levelSize;i++){
                String curWord = q.poll();
                for(int j=0;j<curWord.length();j++){
                    char ca[] = curWord.toCharArray(); 
                    char curChar = curWord.charAt(j);
                    for(char c='a';c<='z';c++){
                        ca[j]=c;
                        String newWord = new String(ca);
                        if(set.contains(newWord)){
                            if(endWord.equals(newWord)){
                                return level+1;
                            }
                            
                            q.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                        ca[j]=curChar;
                }
            }
                level++;
        }
            
        
            return 0;
            
        }
    }
