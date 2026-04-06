class Solution {
    public int numDistinct(String s, String t) {
        int dp[][]  = new int[s.length()][t.length()];
        return  recur(s,t,0,0);
    }

    public int recur(String s, String t, int i1,int i2){
        if(i2==t.length()) return 1;

        int res=0;

        if(i1<s.length()){
            if(s.charAt(i1)!=t.charAt(i2)){
                res = recur(s,t,i1+1,i2);
            }

            if(s.charAt(i1)==t.charAt(i2)){
               res += recur(s,t,i1+1,i2+1) + recur(s,t,i1+1,i2);
            }
        }

        return res;
    }
}
