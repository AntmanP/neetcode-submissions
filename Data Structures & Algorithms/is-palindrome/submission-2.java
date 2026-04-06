class Solution {
    public boolean isPalindrome(String s) {
        int j = s.length()-1, i =0;
       while(i<j){
            while(i<s.length()-1 && !Character.isLetterOrDigit(s.charAt(i)))i++;
            while(j>=0 && !Character.isLetterOrDigit(s.charAt(j)))j--;
            if(i<s.length()-1 && j>=0 && Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }
}
