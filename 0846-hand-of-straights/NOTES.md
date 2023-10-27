```
class Solution {
public boolean isNStraightHand(int[] hand, int groupSize) {
Map<Integer,Integer> treeMap = new TreeMap<>();
for(int i=0;i<hand.length;i++)
treeMap.put(hand[i],treeMap.getOrDefault(hand[i],0)+1);
for(int key :treeMap.keySet()){
if(treeMap.get(key)>0){
int count = treeMap.get(key);
treeMap.put(key,0);
for(int i=1;i<groupSize;i++){
if(treeMap.getOrDefault(key+i,0)<count){
return false;
}
treeMap.put(key+i,treeMap.getOrDefault(key+i,0)-count);
}
}
}
return true;
}