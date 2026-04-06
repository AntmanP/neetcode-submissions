class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        
        if (digits.isEmpty()) return ans;

        Map<Integer, String> map = Map.of(
            2 , "abc",
            3 , "def",
            4 , "ghi",
            5 , "jkl",
            6 , "mno",
            7 , "pqrs",
            8 , "tuv",
            9 , "wxyz"
        );
        
       
        recur(0,new StringBuilder(),digits,map,ans);

        return ans; 
    }

    public void recur(int ind, StringBuilder sb, String digits, Map<Integer, String> map, List<String> ans){
        if(ind  == digits.length()){
            ans.add(sb.toString());
            return;
        }

        // for(int i=ind;i<digits.length();i++){
            String s = map.get(digits.charAt(ind) - '0');
            for(int j=0;j<s.length();j++){
                sb.append(s.charAt(j));
                recur(ind+1,sb,digits,map,ans);
                sb.delete(sb.length()-1,sb.length());
            }
        // }
    }
}
