class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 1; i <= n; i++)
            arr[i] = nums[i - 1];

        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) Arrays.fill(row, -1);

        return recur(arr,1,nums.length,dp);
    }

    public int recur(int arr[],int i,int j,int[][] dp){   
        if(i>j) return 0;


        if(dp[i][j]!=-1) return dp[i][j];

        int max = Integer.MIN_VALUE;
        for(int ind = i ;ind<=j; ind++){
            int cost = arr[i-1] * arr[ind] * arr[j+1] + recur(arr,ind+1,j,dp)  + recur(arr,i,ind-1,dp);
            max = Math.max(cost,max);
        }

        return dp[i][j] = max;
    }
}
