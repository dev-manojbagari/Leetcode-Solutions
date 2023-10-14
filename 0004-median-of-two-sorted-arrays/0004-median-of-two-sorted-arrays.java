class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            int[] t = nums1;
            nums1=nums2;
            nums2=t;
        }
        
        int n1=nums1.length,n2=nums2.length;
        int left=0,right=n1;
        
        while(left<=right){
            int cut1=left+(right-left)/2;
            int cut2 = ((n1+n2)/2)-cut1;
            
            int l1 = (cut1==0)?Integer.MIN_VALUE:nums1[cut1-1];
            int r1 = (cut1==n1)?Integer.MAX_VALUE:nums1[cut1];
          
            int l2 = (cut2==0)?Integer.MIN_VALUE:nums2[cut2-1];
            int r2 = (cut2==n2)?Integer.MAX_VALUE:nums2[cut2];
          
            if(l1<=r2&&l2<=r1){
                if((n1+n2)%2==0)
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                else
                    return Math.min(r1,r2);
            }else if(l1>r2){
                right=cut1-1;
            }else
                left=cut1+1;
        }
        
        return 0;
    }
}