class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> list = new ArrayList<>();

        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());

        for(int i=0;i<times.length;i++){
            int u = times[i][0]-1;
            int v = times[i][1]-1;
            int c = times[i][2];
            list.get(u).add(new int[]{v,c});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

        pq.offer(new int[]{0,k-1});

        HashSet<Integer> set = new HashSet<>();
        int total_cost = 0;
        while(!pq.isEmpty()){
            int nodes[] = pq.poll();
            int cost = nodes[0];
            int node = nodes[1];

            if(set.contains(node)) continue;
            
            set.add(node);
            total_cost = cost;

            for(int[] adj : list.get(node)){
                int nn = adj[0];
                int nc = adj[1];

                if(!set.contains(nn))
                    pq.offer(new int[]{cost+nc,nn});
            }
        }

        return set.size() == n ? total_cost : -1;
    }
}
