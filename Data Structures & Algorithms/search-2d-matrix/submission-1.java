class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        int i=0,j=m;

        while(i<=j){
            int mid = (i+j)/2;
            if(matrix[mid][n] == target) return true;
            else if(matrix[mid][n] > target) j = mid-1;
            else i = mid+1;
        }
        if(i>m) return false;
        int cs = 0;
        int ce = n;
        while(cs<=ce){ 
            int mid = (cs+ce)/2;
            if(matrix[i][mid] == target) return true;
            else if(matrix[i][mid] > target) ce = mid-1;
            else cs = mid+1;
        }

        return false;
    }
}
