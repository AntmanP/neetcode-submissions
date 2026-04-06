class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
            for(int k=0;k<s.length();k++){
                int i=k,j=k;
                while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
                    if(j-i+1 > ans.length())
                        ans = s.substring(i,j+1);
                    i--;j++;
                }
                i=k;j=k+1;
                while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
                    if(j-i+1 > ans.length())
                        ans = s.substring(i,j+1);
                    i--;j++;
                }
            }

        return ans;
    }
}
