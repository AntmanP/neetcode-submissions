class Solution {
    public int lengthOfLIS(int[] nums) {
        return recur(nums,0,-1);
    }

    public int recur(int nums[], int i, int j){
        if(i == nums.length){
            return 0;
        }

           
            int take = recur(nums,i+1,j);
          

            if(j == -1 || nums[j]<nums[i])
            take = Math.max(take, 1 + recur(nums,i+1,i));

        return take;
    }
}
