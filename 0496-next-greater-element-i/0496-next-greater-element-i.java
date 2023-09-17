class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums2.length;
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        
        int[] ng = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!stack.isEmpty()&&nums2[stack.peek()]<=nums2[i])
                stack.pop();
                
            ng[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
         }
        
        
         int[] res  = new int[nums1.length];
        
         for(int i=0;i<nums1.length;i++){
                int index = ng[map.get(nums1[i])];
                res[i]=index!=-1?nums2[index]:-1;
         }
            
            return res;
        }
    }
