class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];

        for(int i=0;i<coins.length;i++)
            Arrays.fill(dp[i],-1);

        return recur(coins,0,amount,dp);
    }

    public int recur(int[] coins, int ind, int amount,int[][] dp){
        if(amount==0){
            return 1;
        }

        if(ind == coins.length){
            return 0;
        }

        if(dp[ind][amount] != -1) return dp[ind][amount];

        int take = 0;
        if(amount >= coins[ind])
            take = recur(coins,ind,amount-coins[ind],dp);

        take += recur(coins,ind+1,amount,dp);


        return dp[ind][amount] = take;
    }
}
