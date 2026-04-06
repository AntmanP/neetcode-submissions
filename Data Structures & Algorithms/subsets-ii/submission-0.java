class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>  res = new ArrayList<>();
        Arrays.sort(nums);
        recur(nums, 0, new ArrayList<>(), res);

        return res;
    }

    public void recur(int nums[], int ind, List<Integer> list,List<List<Integer>> res){
        if(ind == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

            list.add(nums[ind]);
            recur(nums,ind+1,list,res);
            int i = ind;
            while(i<nums.length-1 && nums[i] == nums[i+1]) i++;
            ind = i;
            list.remove(list.size()-1);
            recur(nums,ind+1,list,res);
        
    }
}
