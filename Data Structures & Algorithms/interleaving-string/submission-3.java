class Solution {
    public Boolean[][] dp ;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;

        dp = new Boolean[m + 1][n + 1];
        return recur(s1,s2,s3,0,0,0);
    }



    public boolean recur(String s1, String s2, String s3, int i1, int i2, int i3){
        if(i3 == s3.length()){
            return (i1 == s1.length() && i2 == s2.length()) ;
        }

         if (dp[i1][i2] != null) {
            return dp[i1][i2];
        }

        boolean res = false;
        if(i1<s1.length() && s1.charAt(i1) == s3.charAt(i3)){
            res = recur(s1,s2,s3,i1+1,i2,i3+1);
        }

        if(!res && i2<s2.length() && s2.charAt(i2) == s3.charAt(i3)){
            res = res || recur(s1,s2,s3,i1,i2+1,i3+1);
        }

         return dp[i1][i2] = res;
    }
}
