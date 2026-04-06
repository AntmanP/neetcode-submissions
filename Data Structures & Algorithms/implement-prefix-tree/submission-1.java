public class Trie{
    Trie[] node = new Trie[26];
    boolean endOfWord = false;
}

class PrefixTree {
    private Trie root;
    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie curr = root;

        for(char c: word.toCharArray()){
            if(curr.node[c-'a'] == null)
                curr.node[c-'a'] = new Trie();

            curr = curr.node[c-'a'];
        }

        curr.endOfWord = true; 
    }

    public boolean search(String word) {
        Trie curr = root;

        for(char c: word.toCharArray()){
            if(curr.node[c-'a']==null) 
                return false;

            curr = curr.node[c-'a'];
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        Trie curr = root;

        for(char c: prefix.toCharArray()){
            if(curr.node[c-'a']==null)
             return false;

            curr = curr.node[c-'a'];
        }

        return true;
    }
}
