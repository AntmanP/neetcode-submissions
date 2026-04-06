class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return recur(0,s,dp);    
    }

    public int recur(int i, String s,int[] dp){
        if(s.length() == i){
            return 1;
        }

        if(s.charAt(i) == '0') return 0;

        if(dp[i]!=-1) return dp[i];

        int left = recur(i+1,s,dp);

  
        if(i<s.length()-1){
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1)  < '7') )
                left += recur(i+2,s,dp);
        }
            

        return dp[i] = left;

    }

}
