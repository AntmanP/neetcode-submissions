class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        
        for(int a : nums){
            map.put(a , map.getOrDefault(a,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = freq.length-1;i>0 && index<k;i--){
            for(int j=0;j<freq[i].size();j++){
                res[index++] = freq[i].get(j);
                if(index == k) return res;
            }
        }


        return res;
    }

}
