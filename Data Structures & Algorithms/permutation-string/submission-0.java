class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map = new HashMap<>();
        
        for(char c: s1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int need = map.size();
        for(int i=0;i<s2.length();i++){
            Map<Character,Integer> map1 = new HashMap<>();
            int cur=0;
            for(int j=i;j<s2.length();j++){
               char c= s2.charAt(j);
               map1.put(c,map1.getOrDefault(c,0)+1);   
               
               if(map.getOrDefault(c,0) < map1.get(c)) break;

               if(map.get(c) == map1.get(c)){
                cur++;
               }

                if(cur == need){
                    return true;
                }
            }
        }

        return false;
    }
}
