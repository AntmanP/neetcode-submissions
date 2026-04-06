class Solution {
    public int minDistance(String word1, String word2) {
        return recur(word1, word2, 0, 0);
    }

    public int recur(String s1, String s2, int i1, int i2){
        if (i1 == s1.length()) return s2.length() - i2;
        if (i2 == s2.length()) return s1.length() - i1;

        if(s1.charAt(i1)==s2.charAt(i2)) return recur(s1,s2,i1+1,i2+1);

          
            int a = 1 + recur(s1,s2,i1,i2+1);
            int b = 1 + recur(s1,s2,i1+1,i2);
            int c = 1 + recur(s1,s2,i1+1,i2+1);

        return Math.min(Math.min(b,c),a);
    }
}
