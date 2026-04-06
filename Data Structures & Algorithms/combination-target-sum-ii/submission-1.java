class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        recur(candidates, 0, target, res, new ArrayList<>());
        return res;
    }

    public void recur(int[] candidates, int ind, int target, List<List<Integer>> res, List<Integer> list){
            if(target == 0) 
            {
                res.add(new ArrayList<>(list));
                return;
            }
            if(ind == candidates.length) return;
            if(candidates[ind] > target) return;

            for(int i=ind;i<candidates.length;i++){
                while(i>ind && i<candidates.length && candidates[i]  == candidates[i-1]) i++;

                if(i<candidates.length){
                    list.add(candidates[i]);
                    recur(candidates,i+1,target-candidates[i],res,list);
                    list.remove(list.size()-1);
                }
            }
    }
}
