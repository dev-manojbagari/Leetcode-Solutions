class Twitter {
    class TweetInfo{
        int tweetId;
        int count;
        TweetInfo(int count,int tweetId){
            this.count=count;
            this.tweetId=tweetId;
        }
    }
    
    Map<Integer,Set<Integer>> followMap;
    Map<Integer,List<TweetInfo>> userTweets;
    static int count=0;

    public Twitter() {
        followMap = new HashMap<>();
        userTweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userTweets.containsKey(userId)){
            userTweets.put(userId,new LinkedList<>());
            follow(userId,userId);
        }
        
        userTweets.get(userId).add(new TweetInfo(count++,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<TweetInfo> pq = new PriorityQueue<>((a,b)->a.count-b.count);
        List<Integer> newsFeed = new ArrayList<>();
        Set<Integer> followees = followMap.get(userId);
        if(followees==null)
            return newsFeed;
        
        for(int followee:followees){
            List<TweetInfo> tweets = userTweets.get(followee);
            if(tweets==null)
                continue;
            for(TweetInfo tweet:tweets){
                if(pq.size()<10){
                    pq.offer(tweet);
                }else if(tweet.count>pq.peek().count){
                    pq.poll();
                    pq.offer(tweet);
                }
            }
        }
        
        while(!pq.isEmpty())
            newsFeed.add(0,pq.poll().tweetId);
        
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId,(k->new HashSet<>())).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId))
            followMap.get(followerId).remove(followeeId);
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