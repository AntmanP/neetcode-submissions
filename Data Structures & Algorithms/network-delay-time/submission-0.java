class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> edges = new HashMap<>();

        for (int[] time : times) {
           edges.computeIfAbsent(time[0],
            key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );

        minHeap.offer(new int[]{0,k});

        Set<Integer> visited = new HashSet<>();
        int t = 0 ;

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int w = curr[0], d = curr[1];

            if(visited.contains(d)) continue;

            visited.add(d);
            t = w;

            if(edges.containsKey(d)){
                for(int[] next : edges.get(d)){
                    int nd = next[0], nw = next[1];
                    if(!visited.contains(nd)){
                        minHeap.offer(new int[]{w + nw,nd});
                    }
                }
            }
        }

        return visited.size() == n ? t : -1;
    }
}
