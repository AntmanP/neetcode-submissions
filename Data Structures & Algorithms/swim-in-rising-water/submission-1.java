class Solution {
    public int swimInWater(int[][] grid) {
        int n= grid.length;
        boolean visited[][] = new boolean[n][n];
        return dfs(0,0,grid,visited,0);
    }


    public int dfs(int r, int c, int[][] grid, boolean visited[][], int time){
        if(r<0 || c<0 || r>grid.length-1 || c>grid.length-1 || visited[r][c]) return 10000000;

        if(r==grid.length-1 && c==grid.length-1) return Math.max(time,grid[r][c]);

        visited[r][c] = true;
        time = Math.max(time, grid[r][c]);

        time = Math.min(Math.min(dfs(r-1,c,grid,visited,time),
        dfs(r+1,c,grid,visited,time)),
        Math.min( dfs(r,c-1,grid,visited,time),
        dfs(r,c+1,grid,visited,time)));
        visited[r][c] = false;

        return time;
    }
}
