```
void sortedMerge(Pair[] pair ,int start,int mid,int end ,int[] cs){
Pair L[] = new Pair[mid-start+1];
Pair R[] = new Pair[end-mid];
for(int i=0;i<L.length;i++)
L[i]= pair[start+i];
for(int i=0;i<R.length;i++)
R[i]= pair[mid+1+i];
int i=0,j=0,k=start;
while(i<L.length&&j<R.length){
if(L[i].value<=R[j].value){
cs[L[i].index]+=j;
pair[k++]=L[i++];
}else{
pair[k]=R[j];
j++;
k++;
}
}