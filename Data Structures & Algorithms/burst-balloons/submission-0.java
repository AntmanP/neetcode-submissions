class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 1; i <= n; i++)
            arr[i] = nums[i - 1];

        return recur(arr,1,nums.length);
    }

    public int recur(int arr[],int i,int j){   
        if(i>j) return 0;

        int max = Integer.MIN_VALUE;
        for(int ind = i ;ind<=j; ind++){
            int cost = arr[i-1] * arr[ind] * arr[j+1] + recur(arr,ind+1,j)  + recur(arr,i,ind-1);
            max = Math.max(cost,max);
        }

        return max;
    }
}
