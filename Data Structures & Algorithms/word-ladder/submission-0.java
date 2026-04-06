class Pair{
    String word;
    int level;

    Pair(String word, int level){
        this.word = word;
        this.level = level;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set  = new HashSet<>();

        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);

        while(!q.isEmpty()){
            Pair curr = q.poll();
            String curr_word = curr.word ; 
            int curr_level = curr.level;
            if(curr_word.equals(endWord)) return curr_level;

            for(int i=0;i<curr_word.length();i++){
                for(int j=0;j<26;j++){
                    char[] arr = curr_word.toCharArray();
                    arr[i] = (char)('a' + j) ;
                    String curr_string = String.valueOf(arr);
                    if(set.contains(curr_string)){
                        q.add(new Pair(curr_string,curr_level+1));
                        set.remove(curr_string);
                    }
                }
            }
        }

        return 0;
    }
}