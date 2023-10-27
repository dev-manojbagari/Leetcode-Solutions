```
class Solution {
class DSU{
int[] parent;
int[] size;
DSU(int n){
parent = new int[n];
size = new int[n];
​
for(int i=0;i<n;i++)
{
parent[i]=i;
size[i]=1;
}
}
int findUP(int x){
if(parent[x]==x)
return x;
int up = findUP(parent[x]);
parent[x]=up;
return up;
}
void unionBySize(int a,int b){
int upA = findUP(a);
int upB = findUP(b);
if(upA==upB)
return;
if(size[upA]>=size[upB]){