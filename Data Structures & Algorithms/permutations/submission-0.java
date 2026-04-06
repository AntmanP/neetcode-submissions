class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean v[] = new boolean[nums.length];

        recur(nums, v, res, new ArrayList<>());

        return res;
    }
    public void recur(int nums[], boolean[] v, List<List<Integer>> res, List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!v[i]){
                v[i] = true;
                list.add(nums[i]);
                recur(nums,v,res,list);
                list.remove(list.size()-1);
                v[i] = false;
            }
        }
    }
}
