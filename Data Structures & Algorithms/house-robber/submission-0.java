class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length+1];

        Arrays.fill(dp,-1);

        return dfs(nums,0,dp);
    }

    public int dfs(int[] nums, int ind,int dp[]){
        if(ind > nums.length-1){
            return 0;
        }

        if(dp[ind]!=-1) return dp[ind];

        int left = dfs(nums,ind+1,dp);

        int right = nums[ind] + dfs(nums,ind+2,dp);

        return dp[ind] = Math.max(left,right);

    }
}
