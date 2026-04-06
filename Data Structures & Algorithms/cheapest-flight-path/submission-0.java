class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int[]>> list = new HashMap<>();
        
        for(int[] f : flights){
            list.putIfAbsent(f[0], new ArrayList<>());
            list.get(f[0]).add(new int[]{f[1], f[2]});
        }


        int res = Integer.MAX_VALUE;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src,0});

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;



        while(!q.isEmpty() && k>=0){
            int size = q.size();
            int[] temp = cost.clone(); 

            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int node = curr[0];
                int price = curr[1];

                if(!list.containsKey(node)) continue;

                for(int[] nei : list.get(node)){
                    int next = nei[0];
                    int newCost = price + nei[1];

                    if(newCost < temp[next]){
                        temp[next] = newCost;
                        q.offer(new int[]{next, newCost});
                    }
                }
            }
            cost = temp;
            k--;
        }




        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst] ;

    }
}
