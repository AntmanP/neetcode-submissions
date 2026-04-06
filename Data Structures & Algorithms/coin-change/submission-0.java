class Solution {

    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[coins.length];
        // int deno[] = new int[]{-1}
        int ans = recur(0,coins,amount);
        return ans == Integer.MAX_VALUE ? -1 : ans ;
    }

    public int recur(int ind, int[] coins, int amount){
        
            if(amount == 0){
                return 0;
            }
            
            if (amount < 0 ||ind == coins.length) 
                return Integer.MAX_VALUE;
         

        int left =  recur(ind,coins,amount-coins[ind]);
        if (left != Integer.MAX_VALUE) {
            left = 1 + left;
        }
        
        int right = recur(ind+1,coins,amount);     

        // return deno = Math.min(left,right);
        return Math.min(left,right);
    }
}
