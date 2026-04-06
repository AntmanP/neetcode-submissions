class Solution {
    public int trap(int[] height) {
        int r=0,l=0,n=height.length;
        int fill=0;
        for(int i=0;i<n;i++){
            int left = height[i];
            for(int j=0;j<i;j++){
                left=Math.max(height[j],left);
            }

            int right = height[i];
            for(int j=i+1;j<n;j++){
                right=Math.max(right, height[j]);
            }

            fill+= Math.min(right,left) - height[i];
        }
        return fill;
    }
}
