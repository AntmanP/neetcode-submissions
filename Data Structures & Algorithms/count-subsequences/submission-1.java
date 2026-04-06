class Solution {
    public int numDistinct(String s, String t) {
        int dp[][]  = new int[s.length()][t.length()];

        for(int i=0;i<s.length();i++)Arrays.fill(dp[i],-1);

        return  recur(s,t,0,0,dp);
    }

    public int recur(String s, String t, int i1,int i2,int[][] dp){
        if(i2==t.length()) return 1;
        
        if(i1>s.length()-1) return 0;

        if(dp[i1][i2]!=-1) return dp[i1][i2];

        int res=0;

        if(i1<s.length()){
            if(s.charAt(i1)!=t.charAt(i2)){
                res = recur(s,t,i1+1,i2,dp);
            }

            if(s.charAt(i1)==t.charAt(i2)){
               res += recur(s,t,i1+1,i2+1,dp) + recur(s,t,i1+1,i2,dp);
            }
        }

        return dp[i1][i2] = res;
    }
}
