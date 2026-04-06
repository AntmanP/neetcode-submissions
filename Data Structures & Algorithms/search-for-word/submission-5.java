class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] vis = new int[m][n];
        
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word.charAt(0) == board[i][j]){
                    if(dfs(board, vis, word, i, j, 0)) return true;
                }
            }
            
        }
        
        return false;
    }

    public boolean dfs(char[][] board, int[][] vis, String word, int i, int j, int c){
        if(i<0 || i > board.length-1 || j<0  || j>board[0].length-1 || vis[i][j] ==1 || word.charAt(c) != board[i][j]) {
            return false;
        }

        vis[i][j] = 1;

        if(c == word.length()-1) return true;

        if( dfs(board, vis, word, i+1 , j, c+1) ||  dfs(board, vis, word, i , j+1, c+1) || 
        dfs(board, vis, word, i-1 , j, c+1) || dfs(board, vis, word, i , j-1, c+1) )     
               return true;

        vis[i][j] = 0;
        return false; 
    }
}
