class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, curr_sum = 0;

        for(int j=0;j<nums.length;j++){
            if(curr_sum < 0) curr_sum = 0;
            curr_sum += nums[j];
            max = Math.max(curr_sum, max);
        }

        return max;
    }
}
