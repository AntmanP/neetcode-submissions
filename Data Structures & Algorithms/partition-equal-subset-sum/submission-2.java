class Solution {
    public boolean canPartition(int[] nums) {
        return recur(nums,0,0,0);
    }

    public boolean recur(int[] nums, int ind, int s1, int s2){
            if(ind == nums.length){
                if(s1==s2)   return true;
                else return false;
            }

        return  recur(nums,ind+1,s1+nums[ind],s2)  ||
recur(nums,ind+1,s1,s2+nums[ind]);

    }

}
