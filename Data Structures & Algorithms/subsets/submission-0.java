class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        pnc(nums,0,list,res);
        return res;
    }

    public void pnc(int[] nums, int i, List<Integer> list, List<List<Integer>> res){
        if(i==nums.length){res.add(new ArrayList<>(list));return;}
        list.add(nums[i]);
        pnc(nums,i+1,list,res);
        list.remove(list.size()-1);
        pnc(nums,i+1,list,res);
    }
}
