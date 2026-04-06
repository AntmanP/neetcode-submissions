class Solution {
    public int trap(int[] height) {
        int r=0,l=0,n=height.length;
        int fill=0;
        int[] lmax = new int[n];
        int[] rmax = new int[n];

        int max = 0;
        for(int i=0;i<n;i++){
            lmax[i] = max;
            if(height[i]>max) max = height[i]; 
        }
        max=0;
         for(int i=n-1;i>=0;i--){
            rmax[i] = max;
            if(height[i]>max) max = height[i]; 
        }

        for(int i=0;i<n;i++){
            if(Math.min(lmax[i],rmax[i]) - height[i] > 0)
                fill+=Math.min(lmax[i],rmax[i]) - height[i];
        }

        return fill;
    }
}
