class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean vis[] = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        recur(nums,vis,temp,ans);
        return ans;
    }

    public void recur(int[] nums, boolean[] vis, List<Integer> temp, List<List<Integer>> ans ){
        if(temp.size()==nums.length)
            ans.add(new ArrayList<>(temp));

        for(int i=0;i<nums.length;i++){
            if(!vis[i]){
                temp.add(nums[i]);
                vis[i] = true;
                recur(nums, vis, temp, ans);
                temp.remove(temp.size()-1);
                vis[i] = false;
            }
        }
    }
}
