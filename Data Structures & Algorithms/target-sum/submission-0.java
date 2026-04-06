class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return recur(nums,0,target);
    }
    public int recur(int[] nums, int ind, int target){
        if(ind == nums.length){
            if(target == 0){
                return 1;
            }

            return 0;
        }

        int ans = 0;

        ans = recur(nums,ind+1,target - nums[ind]);
        ans += recur(nums,ind+1,target + nums[ind]);

        return ans;
    }
}
