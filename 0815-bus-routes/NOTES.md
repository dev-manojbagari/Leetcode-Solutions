while(!q.isEmpty()){
int size=q.size();
for(int i=0; i<size; ++i){
Integer curStop=q.poll();
List<Integer> buses=stopMap.get(curStop);
for(Integer bus:buses){
if(busTaken.contains(bus)) continue;
busTaken.add(bus);
for(Integer nextStop:routes[bus]){
if(stopTaken.contains(nextStop)) continue; // Corrected condition
if(nextStop == target)
return busCount+1;
​
q.offer(nextStop);
stopTaken.add(nextStop);
}
}
}
busCount++;
}
​
return -1;
}
}
​
```