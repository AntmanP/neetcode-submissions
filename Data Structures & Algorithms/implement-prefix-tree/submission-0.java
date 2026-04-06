class PrefixTree {
    HashSet<String> set;
    public PrefixTree() {
        set = new HashSet<>();
    }

    public void insert(String word) {
        set.add(word);
    }

    public boolean search(String word) {
        return set.contains(word);
    }

    public boolean startsWith(String prefix) {
        for(String s: set){
        if(s.length() < prefix.length()) continue;
        if(s.substring(0,prefix.length()).equals(prefix)) return true;
        }
        return false;
    }
}
