if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]==0)
continue;
dsu.unionBySize(i*cols+j,x*cols+y);
}
}
}
}
Set<Integer> set = new HashSet<>();
int max=Arrays.stream(dsu.size).max().getAsInt();
for(int i=0;i<rows;i++){
for(int j=0;j<cols;j++){
if(grid[i][j]==0){
for(int[] dir:dirs){
int x = i+dir[0];
int y = j+dir[1];
if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]==0)
continue;
if(dsu.findUP(i*cols+j)!=dsu.findUP(x*cols+y))
set.add(dsu.findUP(x*cols+y));
}
}
int total = 1;
for(int up:set){
total += dsu.size[up];
}
max = Math.max(max,total);
set.clear();
}
}
return max;
}
}
```
​