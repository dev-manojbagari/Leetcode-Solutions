class Solution {
    class DSU{
        int[] parent;
        int[] size;
        
        DSU(int n){
            parent = new int[n];
            size = new int[n];

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
                size[upA]+=size[upB];
                parent[upB]=upA;
            }else{
                size[upB]+=size[upA];
                parent[upA]=upB;
            }
            
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU(accounts.size());
        Map<String,Integer> map = new HashMap<>();
        
        for(int curListId=0;curListId<accounts.size();curListId++){
           List<String> emails =  accounts.get(curListId);
            for(int i=1;i<emails.size();i++){
                String name = emails.get(i);
                if(!map.containsKey(name)){
                    map.put(name,curListId);
                }else{
                    dsu.unionBySize(curListId,map.get(name));
                }
            }
        }
        List<List<String>> mergedAccounts = new ArrayList<>();
        
        for(int i=0;i<accounts.size();i++){
            mergedAccounts.add(new ArrayList<>());
        }
        
        for(String name:map.keySet()){
            int up = dsu.findUP(map.get(name));
            mergedAccounts.get(up).add(name);
        }
        List<List<String>> list = new ArrayList<>();
        for(int i=0;i<mergedAccounts.size();i++){
            if(mergedAccounts.get(i).size()==0) 
                continue;
            String name = accounts.get(i).get(0);
            List<String> tempList = new ArrayList<>();
            tempList.add(name);
            mergedAccounts.get(i).sort((a,b)->a.compareTo(b));
            tempList.addAll(mergedAccounts.get(i));
            list.add(tempList);
        }
        
        
//         return list;
//         class Solution {
//      class DisjointSet {
//         int[] parent;
//         int[] size;

//         DisjointSet(int n) {
//             parent = new int[n];
//             size = new int[n];

//             for (int i = 0; i < n; i++) {
//                 parent[i] = i;
//                 size[i] = 1;
//             }
//         }

//         int findUP(int a) {
//             if (a == parent[a]) return a;

//             return parent[a] = findUP(parent[a]);
//         }

//         void unionBySize(int a, int b) {
//             int upA = findUP(a);
//             int upB = findUP(b);

//             if (size[upA] < size[upB]) {
//                 parent[upA] = upB;
//                 size[upB] += size[upA];
//             } else {
//                 parent[upB] = upA;
//                 size[upA] += size[upB];
//             }
//         }
//     }

//     public List<List<String>> accountsMerge(List<List<String>> accounts) {
//         Map<String,Integer> map= new HashMap<>();

//         DSU dsu = new DSU(accounts.size());
        
//         for(int curListId=0;curListId<accounts.size();curListId++){
//             List<String> curList = accounts.get(curListId);
//             for(int j=1;j<curList.size();j++){
//                 String str = curList.get(j);
//                 if(!map.containsKey(str))
//                     map.put(str,curListId);
//                 else{
//                    int orgListId =map.get(str);
//                     dsu.unionBySize(curListId,orgListId);
//             }
//                    }
//         }    
//             List<List<String>> mergedAccount = new ArrayList<>();
            
//             for(int i=0;i<accounts.size();i++)
//                 mergedAccount.add(new ArrayList<>());
            
//             for(String email:map.keySet()){
//                 int orgListId = dsu.findUP(map.get(email));
//                 mergedAccount.get(orgListId).add(email);
//             }
            
//     List<List<String>> ans = new ArrayList<>();

//         for (int i = 0; i < mergedAccounts.size(); i++) {
//             if (mergedAccounts.get(i).size() > 0) {
//                 List<String> list = new ArrayList<>();
//                 list.add(accounts.get(i).get(0));
//                 mergedAccounts.get(i).sort(String::compareTo);
//                 list.addAll(mergedAccounts.get(i));
//                 ans.add(list);
//             }
//         }

        return list;
        }
}
