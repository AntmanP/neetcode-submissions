class Solution {
    public List<String> generateParenthesis(int n) {   
        List<String> list = new ArrayList<>();
        permute(0,0,n,new StringBuilder(),list);
        return list;
    }

    public void permute(int o, int c, int n ,StringBuilder string, List<String> list){
        if(o == c && o == n){ 
            list.add(string.toString());
            return; 
        }

        if(o < n){
            string.append('(');
            permute(o+1,c,n,string,list);
            string.deleteCharAt(string.length()-1);
        }
        
        if(c<o){
            string.append(')');
            permute(o,c+1,n,string,list);
            string.deleteCharAt(string.length()-1);
        }     
        
    }

}
