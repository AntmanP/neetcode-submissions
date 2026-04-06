class Solution {
    public int minCostConnectPoints(int[][] points) {

        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int i=0;i<points.length;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j=i+1;j<points.length;j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{dist, j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{dist, i});
            }
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        minHeap.offer(new int[]{0,0});// cost/dist and index(first element of points)  
        Set<Integer> visited = new HashSet<>();
        int totalCost = 0;
        while(visited.size()<points.length){
            int[] node = minHeap.poll();
            int index = node[1];
            int cost = node[0];
            
            if(visited.contains(index)) continue;
            

            totalCost+= cost;
            visited.add(index);

            for(int conn[]: adj.getOrDefault(index,Collections.emptyList())){
                int dist = conn[0];
                int d = conn[1];
                if(!visited.contains(d)){
                    minHeap.offer(new int[]{dist,d});
                }                   
            }


        }

        return totalCost;
    }
}
