class Solution {
    public boolean canPartition(int[] nums) {
        return recur(nums,0,new ArrayList<>(),new ArrayList<>());
    }

    public boolean recur(int[] nums, int ind, List<Integer> list1, List<Integer> list2){
            if(ind == nums.length){
                int sum = list1.stream()
                        .mapToInt(Integer::intValue)
                        .sum();

                int sum1 = list2.stream()
                        .mapToInt(Integer::intValue)
                         .sum();

                if(sum1==sum)   return true;

                else return false;
            }

            list1.add(nums[ind]);
            boolean a =  recur(nums,ind+1,list1,list2);
            list1.remove(list1.size()-1);
            list2.add(nums[ind]); 
            boolean b =  recur(nums,ind+1,list1,list2);
            list2.remove(list2.size()-1);

            return a||b; 
    }

}
