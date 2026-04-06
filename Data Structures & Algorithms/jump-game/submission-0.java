class Solution {
    public boolean canJump(int[] nums) {
        return recur(nums,0);
    }

    boolean recur(int nums[], int ind){
        if(ind == nums.length - 1) return true;

        if(ind > nums.length - 1) return false;

        for(int i=1;i<=nums[ind];i++){
            if(recur(nums, ind+i)) return true;
        }


        return false;
    }
}
