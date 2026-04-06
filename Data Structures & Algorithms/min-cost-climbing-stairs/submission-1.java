class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length+1];

        Arrays.fill(dp,-1);

        return Math.min(dfs(cost, 0,dp),dfs(cost,1,dp));
    }


    public int dfs(int[] cost, int ind,int[] dp){
        if(ind >= cost.length) 
            return 0;     

        
        if(dp[ind]!=-1) return dp[ind];


        int left = cost[ind] + dfs(cost, ind+1,dp);

        
        int right = cost[ind] + dfs(cost, ind+2,dp);             

        return dp[ind] = Math.min(left,right);
    }
}
