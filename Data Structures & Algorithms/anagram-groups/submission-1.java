class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char arr[] = strs[i].toCharArray();
            int count[] = new int[26];
            for(char c : arr){
                count[c-'a']++;
            }
            String sorted_string = Arrays.toString(count);

            if(!map.containsKey(sorted_string)){
                map.put(sorted_string, new ArrayList<>());
            }
            map.get(sorted_string).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}