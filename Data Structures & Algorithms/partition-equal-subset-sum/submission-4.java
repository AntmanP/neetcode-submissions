class Solution {
    public boolean canPartition(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int sum = 0;

        for(int i=0;i<nums.length;i++)
            sum+= nums[i];

        set.add(0);

        if(sum%2!=0) return false;
        int target=sum/2;


        for(int i=nums.length-1;i>=0;i--){
            HashSet<Integer> ns = new HashSet<>();

            for(int t : set){
                if(t+nums[i] == target) return true;
                ns.add(t);
                ns.add(t+nums[i]);
            }
            set = ns;
        }

        return false;
    }
}
