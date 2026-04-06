class Solution {
    public int maxProduct(int[] nums) {
        int min = 1, max = 1;
        int res = nums[0];
        for(int i=0;i<nums.length;i++){
            // if(nums[i]==0){
            //     min = 1;
            //     max = 1;
            //     continue;
            // }

            int temp = max;
            max = Math.max(min*nums[i], Math.max(nums[i], max * nums[i]));
            min = Math.min(min*nums[i], Math.min(nums[i], temp * nums[i]));

            res = Math.max(res, max);

        }


        return res;
    }
}
