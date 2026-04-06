class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));

        for(int i=0;i<stones.length;i++){
            pq.offer(stones[i]);
        }


        while(pq.size()>1){
            int heavy = pq.poll();
            int heavy2 = pq.poll();

            if(heavy > heavy2)
                pq.offer(heavy-heavy2);

        }


        return pq.size() == 0 ? 0 : pq.peek();
    }
}
