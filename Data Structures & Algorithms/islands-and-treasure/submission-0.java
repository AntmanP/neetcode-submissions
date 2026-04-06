class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
       for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j] == 0)   queue.add(new int[]{i,j,0});
        }
       }

        while(!queue.isEmpty()){
            int[] ele = queue.poll();
            int r = ele[0];
            int c = ele[1];
            int dist = ele[2];
            grid[r][c] = Math.min(grid[r][c],dist);
            int dx[] = {-1,1,0,0};
            int dy[] = {0,0,1,-1};

            for(int i=0;i<dx.length;i++){
                int row = r + dx[i];
                int col = c + dy[i];
                if(row>=0 && col >=0 && row<grid.length && col<grid[0].length && grid[row][col] == Integer.MAX_VALUE)
                    queue.add(new int[]{row,col,grid[r][c]+1});

            }
        }

    }
}
