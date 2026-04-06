class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean vis[] = new boolean[nums.length];
        backtrack(nums,temp,ans,vis);
        return ans;
    }

    public void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> ans, boolean vis[]){
        if(temp.size()==nums.length)
            ans.add(new ArrayList<>(temp));

        for(int i=0;i<nums.length;i++){
            if(!vis[i]){
                vis[i]=true;
                temp.add(nums[i]);
                backtrack(nums,temp,ans,vis);
                vis[i]=false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
