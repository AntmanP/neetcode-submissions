class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> freq = new HashMap<>();
        for(char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c,0)+1);

        Set<Character> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        int count = 0;

        for(char c : s.toCharArray()){
            set.add(c);
            freq.put(c, freq.get(c)-1);
            count++;

            if(freq.get(c) == 0)
                set.remove(c);

            if(set.isEmpty()){
                res.add(count);
                count = 0;
            }
        }
        return res;
    }
}