class Solution {
    public boolean isPalindrome(String s) {
        String word = "";


        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))) word+=Character.toLowerCase(s.charAt(i));
        }

        System.out.println(word);
        for(int i=0;i<word.length()/2;i++)
            if(word.charAt(i)!=word.charAt(word.length()-i-1)) return false;
        return true;
    }
}
