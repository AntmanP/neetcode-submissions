class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        recur(nums, 0, res);

        return res;
    }
    public void recur(int nums[], int ind, List<List<Integer>> res){
        if(ind == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                temp.add(nums[i]);
            }
            res.add(temp);
            return;            
       }

        for(int i=ind;i<nums.length;i++){
            swap(i,ind,nums);
            recur(nums, ind+1, res);
            swap(i,ind,nums);
        }
    }

    public void swap(int a, int b,int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
