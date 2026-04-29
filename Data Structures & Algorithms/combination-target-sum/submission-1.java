class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        recur(nums,0,target,ans, list);
        return ans;
    }
    public void recur(int nums[], int ind , int target, List<List<Integer>> ans, List<Integer> list){
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (ind == nums.length || target < 0) {
            return;
        }
    
        list.add(nums[ind]);
        recur(nums,ind,target- nums[ind],ans,list);
        list.remove(list.size()-1);
        recur(nums,ind+1, target,ans,list);
    }
}
