class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++) Arrays.fill(dp[i],-1);

        return recur(word1, word2, 0, 0,dp);
    }

    public int recur(String s1, String s2, int i1, int i2,int[][] dp){
        if (i1 == s1.length()) return s2.length() - i2;
        if (i2 == s2.length()) return s1.length() - i1;


        if(dp[i1][i2]!=-1) return dp[i1][i2];

        if(s1.charAt(i1)==s2.charAt(i2)) return dp[i1][i2] = recur(s1,s2,i1+1,i2+1,dp);

          
            int a = 1 + recur(s1,s2,i1,i2+1,dp);
            int b = 1 + recur(s1,s2,i1+1,i2,dp);
            int c = 1 + recur(s1,s2,i1+1,i2+1,dp);

        return dp[i1][i2] = Math.min(Math.min(b,c),a);
    }
}
