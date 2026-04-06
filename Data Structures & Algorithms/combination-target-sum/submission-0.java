class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, 0, target, list, res);

        return res;
    }

    public void dfs(int[] nums, int i, int target, List<Integer> list, List<List<Integer>> res){
        if(i==nums.length){
        if(target == 0) {res.add(new ArrayList<>(list));} return;
        }

        if(nums[i]<=target){
        list.add(nums[i]);
        dfs(nums,i,target-nums[i],list,res);
        list.remove(list.size()-1);
        }
        dfs(nums,i+1,target,list,res);
    }
}
