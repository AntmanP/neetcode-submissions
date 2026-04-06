class Solution {
    public List<String> generateParenthesis(int n) {   
        List<String> list = new ArrayList<>();
        permute(0,0,0,n,new char[2*n],list);
        return list;
    }

    public void permute(int o, int c, int index, int n ,char[] ch, List<String> list){
        if(index == 2*n){ 
            list.add(String.valueOf(ch));
            return; 
        }

        if(o < n){
            ch[index] = '(';
            permute(o+1,c,index+1,n,ch,list);
        }
        
        if(c<o){
            ch[index] = ')';
            permute(o,c+1,index+1,n,ch,list);
        }     
        
    }

}
