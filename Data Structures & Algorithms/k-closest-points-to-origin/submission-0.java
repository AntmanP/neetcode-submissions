class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);

        for(int i=0;i<points.length;i++){
            int x = points[i][0];
            int y =  points[i][1];

            pq.offer(new int[]{i, x*x + y*y});
        }


        int ans[][]= new int[k][2];

        int i = 0;
        while(!pq.isEmpty() && k-->0){
            int index =  pq.poll()[0];
            ans[i][0] = points[index][0];
            ans[i][1] = points[index][1];
            i++;
        }


        return ans;
    }
}
