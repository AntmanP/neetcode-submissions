class Solution {
    public int swimInWater(int[][] grid) {
        int n= grid.length;
        boolean visited[][] = new boolean[n][n];
        
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{grid[0][0],0,0});

        while(!minHeap.isEmpty()){
            int block[] = minHeap.poll();
            int t = block[0];
            int r = block[1];
            int c = block[2];
            visited[r][c] = true;
            if(r==n-1 && c==n-1) return t;
            for(int[] d : dir){
                int nr = r + d[0]; 
                int nc = c + d[1];
                if(nr>=0 && nc>=0 && nr<=grid.length-1 && nc<=grid.length-1 && !visited[nr][nc]){
                    
                    minHeap.offer(new int[]{Math.max(t,grid[nr][nc]) ,r + d[0], c + d[1]});
                }
                    
            }

        }
        return n*n;
    }
}
