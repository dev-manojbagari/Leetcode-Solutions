class Solution {
public int repeatedStringMatch(String a, String b) {
StringBuilder sb = new StringBuilder();
int count=0;
while(sb.length()<b.length()){
sb.append(a);
count++;
}
if(isFound(sb.toString(),b)) return count;
else if(isFound(sb.append(a).toString(),b))return count+1;
else
return -1;
}
boolean isFound(String a , String b){
for(int i=0;i<a.length();i++){
int start = i;
int j = 0;
while(start<a.length()&&j<b.length()&&a.charAt(start)==b.charAt(j)){
start++;
j++;
}
if(j==b.length())
return true;
}
return false;
}
}