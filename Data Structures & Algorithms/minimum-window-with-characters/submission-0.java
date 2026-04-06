class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();

        for(char c: t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }


        int need = map.size();
        String ans = "";
        int res = 1001;
        for(int i=0;i<s.length();i++){
            Map<Character,Integer> map1 = new HashMap<>();
            int cur = 0;

            for(int j=i;j<s.length();j++){
                char c = s.charAt(j);
                map1.put(c,map1.getOrDefault(c,0)+1);

                if(map.get(c) == map1.get(c))
                    cur++;

                if(cur == need){
                    if( res > j-i+1 ){
                        res = j-i +1;
                        ans = s.substring(i,j+1);
                    }
                }
            }
        }


        return ans;
    }
}
