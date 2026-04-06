class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m= matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++)
            Arrays.fill(dp[i],-1);

        

        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max = Math.max(max,dfs(matrix,i,j,dp,Integer.MIN_VALUE));
            }
        }
        
        return max;
    }

    public int dfs(int[][] matrix, int i , int j, int[][] dp,int prev){
        if(i<0 || j<0 || i>matrix.length-1 || j> matrix[0].length-1 || prev >= matrix[i][j]) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        
        int a = 1 + dfs(matrix,i-1,j,dp,matrix[i][j]);
        int b = 1 + dfs(matrix,i+1,j,dp,matrix[i][j]);
        int c = 1 + dfs(matrix,i,j-1,dp,matrix[i][j]);
        int d = 1 + dfs(matrix,i,j+1,dp,matrix[i][j]);

       return dp[i][j] =  Math.max(Math.max(a,b),Math.max(c,d));
    }
}
