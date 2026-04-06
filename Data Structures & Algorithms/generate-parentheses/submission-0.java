class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> list = new ArrayList<>();
        permute(n,"(",list);
        return list;
    }

    public void permute(int n, String p, List<String> list){
        if(n*2 == p.length()){
            if(stringValid(p))  list.add(p);

            return; 
        }

        p += "(" ;
        permute(n,p,list);

        p = p.substring(0,p.length()-1);
        p+=  ")";
        permute(n,p,list);
    }

    public boolean stringValid(String s){
        int c = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(')
                c++;

            else 
                c--;

            if(c<0) break;

        }


        return c == 0 ;
    }
}
