class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        return binarySearch(nums,0, nums.length-1, target); 
    }
    public int binarySearch(int[] nums,int left, int right, int target){

        if(left>right) return -1;

        int ind = (left+right)/2;

        if(nums[ind] == target) 
            return ind;
        
        else if(nums[ind] > target){
            return binarySearch(nums, left, ind-1,target); 
        } 

        else if(nums[ind] < target){
            return binarySearch(nums, ind+1, right,target); 
        }

        return -1; 

    }
}
