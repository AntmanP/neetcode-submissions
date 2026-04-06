class Solution {
    Map<Character,Set<Character>> map = new HashMap<>();
    Map<Character, Boolean> visited;
    List<Character> result;

    public String foreignDictionary(String[] words) {

        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                map.putIfAbsent(words[i].charAt(j), new HashSet<>());
            }
        }


        for(int i=0;i<words.length-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];

            int minLen = Math.min(w1.length(),w2.length());

            if(w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0,minLen))) return "";

            for(int j=0;j<minLen;j++){
                if(w1.charAt(j)!=w2.charAt(j)){
                    map.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        visited = new HashMap<>();
        result = new ArrayList<>();
        for(char c : map.keySet()){
            if(dfs(c)) return "";
        }

        Collections.reverse(result);

        StringBuilder ans = new StringBuilder();
        for (char c : result) {
            ans.append(c);
        }

       return ans.toString(); 
    }

    public boolean dfs(char c){
        if(visited.containsKey(c))
            return visited.get(c);

        visited.put(c,true);

        for(char node : map.get(c)){
            if(dfs(node)){
                return true;
            }
        }


        visited.put(c,false);
        result.add(c);
        return false;
    }
}
