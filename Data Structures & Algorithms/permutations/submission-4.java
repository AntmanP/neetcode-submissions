class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // boolean vis[] = new boolean[nums.length];
        // List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        recur(nums,0,ans);
        return ans;
    }

    public void recur(int[] nums , int ind, List<List<Integer>> ans ){
        if(ind==nums.length){
           List<Integer> temp = new ArrayList<>();
           
           for(int i=0;i<nums.length;i++)
            temp.add(nums[i]);
           
            ans.add(new ArrayList<>(temp));
        }
        
        for(int i=ind;i<nums.length;i++){
            swap(i,ind,nums);
            recur(nums,ind+1,ans);
            swap(i,ind,nums);
        }
    }

    public void swap(int i, int j, int nums[]){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
