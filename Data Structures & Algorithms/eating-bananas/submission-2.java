class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i=0;i<piles.length;i++)
            if(max < piles[i]) max = piles[i];

        int low = 1;
        int high = max;
        int speed = 0,ans=Integer.MAX_VALUE;
        while(low<=high){
            speed = (low+high)/2;
            int step = 0;
            for(int i=0;i<piles.length;i++){
                step += Math.ceil((double) piles[i] / speed);
            }
            if(step<=h){
                high = speed-1;
                ans = Math.min(ans,speed);
            }
            else if(step>h) low = speed+1;

        }
      
        return ans;
    }
}
