```
class Solution {
public int numBusesToDestination(int[][] routes, int source, int target) {
Map<Integer,List<Integer>> stopMap = new HashMap<>();
​
for(int i=0;i<routes.length;i++){
for(int j=0;j<routes[i].length;j++){
int bus = i;
int stop = routes[i][j];
stopMap.computeIfAbsent(stop,(key->new ArrayList<>())).add(bus);
}
}
​
if(!stopMap.containsKey(source)||!stopMap.containsKey(target))
return -1;
if(source==target) return 0;
Queue<Integer> q  = new LinkedList<>();
q.add(source);
Set<Integer> busTaken = new HashSet<>();
Set<Integer> stopTaken = new HashSet<>();
stopTaken.add(source); // Add source to visited stops
int busCount=0;
​
while(!q.isEmpty()){
int size=q.size();
​
for(int i=0; i<size; ++i){
Integer curStop=q.poll();
List<Integer> buses=stopMap.get(curStop);
​