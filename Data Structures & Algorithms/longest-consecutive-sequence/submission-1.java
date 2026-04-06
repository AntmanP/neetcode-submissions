class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length ==0 ) return 0;
        Set<Integer> set = new HashSet<>();
        int res = Integer.MIN_VALUE;
        for(int num:nums){
            set.add(num);
        }

        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int len = 1;
                while(set.contains(nums[i]+len)) len++;
                res = Math.max(res, len);
            }
        }

        return res;
    }
}
