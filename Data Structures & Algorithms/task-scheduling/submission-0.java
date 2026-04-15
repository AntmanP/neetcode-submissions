class Solution {
    public int leastInterval(char[] tasks, int n) {
         int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(int c: count)
            if (c > 0) {
                maxHeap.add(c);
            }

        
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;

            if(maxHeap.isEmpty())
                time = q.peek()[1];
            else{
                int rem = maxHeap.poll()-1;
                if (rem > 0) q.add(new int[]{rem,time+n}); 
            }

            if(!q.isEmpty() && q.peek()[1]==time)
                maxHeap.add(q.poll()[0]);
        }

        return time;
    }
}
