class Solution {
    public int jump(int[] nums) {
        int l = 0, r = 0;
        int step = 0;
        
        while(r<nums.length-1){
            int far = 0;
            for(int j=l;j<=r;j++){
                far = Math.max(far,j+nums[j]);
            }
            step++;
            l = r+1;
            r = far;
        } 

        return step;
    }
}
