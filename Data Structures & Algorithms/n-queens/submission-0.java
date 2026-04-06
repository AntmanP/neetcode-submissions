class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> res = new ArrayList<>();

        boolean[] row = new boolean[n];
        boolean[] ud = new boolean[2*n-1];
        boolean[] ld = new boolean[2*n-1];


        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }

        queen(0, board, row, ud, ld, res);

        return res;
    }

    public void queen(int c, char[][] board, boolean[] row, boolean[] ud, boolean[] ld, List<List<String>> res){
        if(c == board.length){
            List<String> curr = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                curr.add(new String(board[i]));
            }
            res.add(new ArrayList<>(curr));
            return;
        }


        for(int r=0;r<board.length;r++){
            int d1= c-r+board.length-1;
            int d2= r + c ;
            if(!row[r] && !ud[d1] && !ld[d2]){
                row[r] = ud[d1] = ld[d2] = true;
                board[r][c] = 'Q';
                queen(c+1, board, row, ud, ld, res);
                board[r][c] = '.';
                 row[r] = ud[d1] = ld[d2] = false;
            }
        }
    }
}