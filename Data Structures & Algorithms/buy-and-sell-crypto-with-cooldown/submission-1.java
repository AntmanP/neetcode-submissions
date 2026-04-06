class Solution {
    public int maxProfit(int[] prices) {
        return profit(prices, 0 , 1);
    }

    public int profit(int[] prices, int ind, int buy){
        if(prices.length <= ind) return 0;

        int buy_option = 0;
        if(buy==1)
            buy_option = Math.max(-prices[ind] + profit(prices, ind+1,0) , profit(prices,ind+1,1));

        else
            buy_option = Math.max(prices[ind] + profit(prices,ind+2,1),profit(prices,ind+1,0));

        return buy_option;
    }
}
