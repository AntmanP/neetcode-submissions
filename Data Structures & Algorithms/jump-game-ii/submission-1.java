class Solution {
    public int jump(int[] nums) {
        return recur(nums,0);
    }
    public int recur(int nums[], int ind){
        if(ind>nums.length-1)
           return 10000;

        if(ind == nums.length-1) return 0;


        int min = 10000;

        for(int i=1;i<=nums[ind];i++){
            int steps = 1 + recur(nums,i+ind);
            min = Math.min(min,steps);
        } 
         

         return min;
    }
}
