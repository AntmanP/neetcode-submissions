class Solution {
    HashMap<Character, Set<Character>> map = new HashMap<>();
    HashMap<Character, Boolean> vis = new HashMap<>();
    List<Character> list = new ArrayList<>();

    public String foreignDictionary(String[] input) {

        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[i].length();j++){
                map.putIfAbsent(input[i].charAt(j), new HashSet<>());
            }
        }

        for(int i=0;i<input.length-1;i++){
            String s1 = input[i];
            String s2 = input[i+1];
            int len = Math.min(s1.length(),s2.length());

            if(s2.length() < s1.length() && s1.substring(0,len).equals(s2.substring(0,len))) return "";
            
            int j=0;
            while(j<len){
                if(s1.charAt(j)!=s2.charAt(j)){
                    map.get(s1.charAt(j)).add(s2.charAt(j));
                    break;
                }
                j++;
            }
        }

        vis = new HashMap<>();
        list = new ArrayList<>();

        for(char c : map.keySet()){
            if(dfs(c)) return "";
        }

        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<list.size();i++)
            sb.append(list.get(i));
        
        return sb.toString();

    }

    public boolean dfs(Character c){
        if(vis.containsKey(c))  
            return vis.get(c);

        vis.put(c,true);

        for(char n : map.get(c)){
            if(dfs(n)) return true;
        }

        vis.put(c,false);
        list.add(c);
        return false;
    }
}
