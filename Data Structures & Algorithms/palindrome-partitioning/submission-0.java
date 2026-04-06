class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        recur(s, 0, res, path);

        return res;
    }

    public void recur(String s, int index, List<List<String>> res, List<String> path){
        if(index == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index,i+1));
                recur(s,i+1,res,path);
                path.remove(path.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    } 
}
