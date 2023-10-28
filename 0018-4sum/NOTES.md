```
class Solution {
public List<List<Integer>> fourSum(int[] nums, int target) {
Arrays.sort(nums);
int n= nums.length;
List<List<Integer>> list = new ArrayList<>();
for(int i=0;i<n-3;i++){
if(i>0&&nums[i-1]==nums[i])
continue;
for(int l=i+1;l<n-2;l++){
if(l>i+1&&nums[l-1]==nums[l])
continue;
int j = l+1;
int k = n-1;
while(j<k){
long sum = (long)nums[i]+nums[l]+nums[j]+nums[k];
if(sum==(long)target){
list.add(Arrays.asList(nums[i],nums[l],nums[j],nums[k]));
j++;
while(j<k&&nums[j]==nums[j-1])
j++;
k--;
while(j<k&&nums[k]==nums[k+1])
k--;
}else if(sum<target){
j++;
}else{
k--;
}
}
}
}
return list;
}
}
```