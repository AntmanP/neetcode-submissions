class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<hand.length;i++){
            map.put(hand[i], 1 + map.getOrDefault(hand[i], 0));
        }

        Arrays.sort(hand);

        for(int i=0;i<hand.length;i++){
            if(map.get(hand[i]) > 0){
                for(int j= hand[i]; j < hand[i] + groupSize;j++){
                    if (map.getOrDefault(j, 0) == 0) return false;

                    map.put(j,map.get(j) - 1);
                }
            }
        }

        return true;
    }
}
