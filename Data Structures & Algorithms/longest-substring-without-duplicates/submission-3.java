class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        char[] arr = s.toCharArray();
        int i=0,size = 0;

       for(int j=0;j<s.length();j++){
        while(set.contains(arr[j])){
            set.remove(arr[i]);
            i++;
        }
        set.add(arr[j]);
        size = Math.max(size,j-i+1);
       }

        return size;
    }
}
