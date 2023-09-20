class Twitter {
    class TweetInfo{
        int tweetId;
        int count;
        
        TweetInfo(int tweetId,int count){
            this.tweetId=tweetId;
            this.count=count;
        }
    }
    
    static int count=0;
    Map<Integer,Set<Integer>> followees;
    Map<Integer,LinkedList<TweetInfo>> userTweets;
    
    public Twitter() {
        followees = new HashMap<>();
        userTweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userTweets.containsKey(userId)){
            userTweets.put(userId,new LinkedList<>());
            follow(userId,userId);
        }
        userTweets.get(userId).add(0,new TweetInfo(tweetId,count++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // get follwers , fillter ten recet tweets
        List<Integer> newsfeed = new ArrayList<>();        
        Set<Integer> users = followees.get(userId);
        if(users==null)
            return newsfeed;
        PriorityQueue<TweetInfo> maxHeap = new PriorityQueue<>((a,b)->a.count-b.count);
        
        for(int user:users){
            List<TweetInfo> tweetInfos = userTweets.get(user);
            if(tweetInfos==null)
                continue;
            for(TweetInfo tweetInfo:tweetInfos){
                
                if(maxHeap.size()<10){
                    maxHeap.offer(tweetInfo);
                }else if(tweetInfo.count>maxHeap.peek().count){
                    maxHeap.poll();
                    maxHeap.offer(tweetInfo);
                }else{
                    break;
                }
            }
        }
        
         while(!maxHeap.isEmpty()){
             newsfeed.add(0,maxHeap.poll().tweetId);
        }
        return newsfeed;
    }
    
    public void follow(int followerId, int followeeId) {
        followees.computeIfAbsent(followerId,(k->new HashSet<>())).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId!=followeeId&&followees.containsKey(followerId))
            followees.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */