postMap.put(userId,new LinkedList<>());
follow(userId,userId);
}
postMap.get(userId).add(0,new TweetInfo(count++,tweetId));
}
public List<Integer> getNewsFeed(int userId) {
PriorityQueue<TweetInfo> pq = new PriorityQueue<TweetInfo>((a,b)->a.count-b.count);
LinkedList<Integer> newsfeed = new LinkedList<>();
Set<Integer> followees = followMap.get(userId);
if(followees==null)
return newsfeed;
for(int followee:followees){
List<TweetInfo> tweets = postMap.get(followee);
if(tweets==null)
continue;
for(TweetInfo tweet:tweets){
if(pq.size()<10){
pq.offer(tweet);
}else{
if(tweet.count<=pq.peek().count)
break;
else{
pq.poll();
pq.offer(tweet);
}
}
}
}
while(!pq.isEmpty()){
newsfeed.add(0,pq.poll().tweetId);
}
return newsfeed;
}
public void follow(int followerId, int followeeId) {
if(!followMap.containsKey(followerId))
followMap.put(followerId,new HashSet<>());
followMap.get(followerId).add(followeeId);
//followMap.computIfAbsent(followerId,(k->new HashSet<>())).add(followeeId);
}
public void unfollow(int followerId, int followeeId) {
if(followMap.containsKey(followerId)&&followerId!=followeeId)
followMap.get(followerId).remove(followeeId);
}
}
​
​