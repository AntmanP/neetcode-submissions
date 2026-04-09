class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int median = (nums1.length + nums2.length)/2;
    
        int i=0,j=0,k=0;
        int n1=0,n2=0;
        while(i<nums1.length && j<nums2.length){
           if(nums1[i]<nums2[j]) {
                if(k==median-1)
                    n1 = nums1[i];
                if(k==median)
                    n2 = nums1[i];

                i++;
            } 
            else{
                if(k==median-1)
                    n1 = nums2[j];
                if(k==median)
                    n2 = nums2[j];
                
                j++;
            }
           k++;
        }

          while(i<nums1.length){
            if(k==median-1) n1 = nums1[i];
            if(k==median) n2 = nums1[i];
            i++;
            k++;
        }

        while(j<nums2.length){  
            if(k==median-1) n1 = nums2[j];
            if(k==median) n2 = nums2[j];
            j++;
            k++;
        }

        if((nums1.length + nums2.length)%2==1){
            return (double)n2;
        }
   
        return (double)(n1+n2) / 2.0;
    
    }
}