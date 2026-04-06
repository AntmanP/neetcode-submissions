class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int ans=0;
        int tank = 0,  n = gas.length;

        for(int i = 0; i< n ;i++){
            tank += gas[i] - cost[i];
            
            if(tank<0){
                tank = 0;
                ans = i+1;
            }
        }

        return ans;
    }
}
