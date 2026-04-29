class TrieNode{
    TrieNode children[];
    boolean eof;

    TrieNode(){
        children = new TrieNode[26];
        eof = false;
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.eof = true;
    }

    public boolean search(String word) {
        return dfs(0,word,root);
    }

    public boolean dfs(int ind, String word, TrieNode root){
        TrieNode curr = root;
        for(int i=ind;i<word.length();i++){
            char c = word.charAt(i);
            if(c=='.'){
                for(TrieNode child: curr.children){
                    if(child!=null && dfs(i+1,word,child)) return true;
                }
                return false;
            }
            else{
                if(curr.children[c-'a']== null) return false;
                curr = curr.children[c-'a'];
            }
        }


        return curr.eof;
    }
}
