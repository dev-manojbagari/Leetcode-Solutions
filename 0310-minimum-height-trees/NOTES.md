for(int i=0;i<n;i++){
if(inDegree[i]==1){
q.add(i);
}
}
while(n>2){
int size = q.size();
n -=size;
for(int i=0;i<size;i++){
int node = q.poll();
for(int x:adjList.get(node)){
inDegree[x]--;
if(inDegree[x]==1){
q.add(x);
}
}
}
}
res.addAll(q);
return res;
}
}
```