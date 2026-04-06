class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> a = new Stack<>();

        int wc = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(') st.push(i);

            if(c == '*') a.push(i);

            if(c == ')'){
                if(!st.isEmpty()){
                    st.pop();
                }
                else if(!a.isEmpty()){
                    a.pop();
                }
                else 
                    return false;
            }
        }

        while(!st.isEmpty() && !a.isEmpty()){
            if(st.pop() > a.pop()) return false;
        }

        return st.isEmpty() ; 
    }
}
