class Solution {
    public int totalSum;
    public int findTargetSumWays(int[] nums, int target) {
         totalSum = 0;
        for (int num : nums) totalSum += num;
        int dp[][] = new int[nums.length][2*totalSum+1];

        for(int i=0;i<nums.length;i++) Arrays.fill(dp[i],Integer.MIN_VALUE);

        return recur(nums,0,target,dp);
    }
    public int recur(int[] nums, int ind, int target,int[][] dp){

        if (target < -totalSum || target > totalSum) 
            return 0;
            
        if(ind == nums.length){
            if(target == 0){
                return 1;
            }

            return 0;
        }

        

        if(dp[ind][totalSum + target] != Integer.MIN_VALUE) return dp[ind][totalSum + target];

        int ans = 0;
        ans = recur(nums,ind+1,target - nums[ind],dp);
        ans += recur(nums,ind+1,target + nums[ind],dp);

        return dp[ind][totalSum + target] = ans;
    }
}
