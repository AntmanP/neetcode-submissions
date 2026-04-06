class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        // char[] arr = s.toCharArray();
        int i=0,size = 0;

       for(int j=0;j<s.length();j++){
        while(set.contains(s.charAt(j))){
            set.remove(s.charAt(i));
            i++;
        }
        set.add(s.charAt(j));
        size = Math.max(size,j-i+1);
       }

        return size;
    }
}
