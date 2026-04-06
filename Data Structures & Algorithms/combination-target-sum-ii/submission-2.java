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

            for(int i=ind;i<candidates.length;i++){
                if(i>ind && candidates[i]  == candidates[i-1]) continue;
                if(candidates[ind] > target) break;

                    list.add(candidates[i]);
                    recur(candidates,i+1,target-candidates[i],res,list);
                    list.remove(list.size()-1);
            }
    }
}
