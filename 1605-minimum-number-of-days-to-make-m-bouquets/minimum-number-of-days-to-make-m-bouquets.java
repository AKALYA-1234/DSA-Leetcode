class Solution {
    public int minDays(int[] nums, int m, int k) {
        int n=nums.length;
        int low=nums[0];
        int high=nums[1];
        if((long)m*k>n){
            return -1;
        }
        for(int i=0;i<n;i++){
            low=Math.min(low,nums[i]);
            high=Math.max(high,nums[i]);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int bouquets=0;
            int flower=0;
            for(int i=0;i<n;i++){
                if(nums[i]<=mid){
                    flower++;
                    if(flower==k){
                       bouquets++;
                       flower=0; 
                    }
                }
                else{
                    flower=0;
                }
            }
            if(bouquets>=m){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}