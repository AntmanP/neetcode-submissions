class Solution {
    public int numDecodings(String s) {
        return recur(0,s);    
    }

    public int recur(int i, String s){
        if(s.length() == i){
            return 1;
        }

        if(s.charAt(i) == '0') return 0;


        int left = recur(i+1,s);

  
        if(i<s.length()-1){
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1)  < '7') )
                left += recur(i+2,s);
        }
            

        return left;

    }

}
