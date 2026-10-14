class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(nums[i],max);
        }
        int ans=max;
        int low=1,high=max;
        while(low<=high){
            int sum=0;
            int mid=low+(high-low)/2;
            for(int j=0;j<n;j++){
                sum+=(nums[j]+mid-1)/mid;
            }
            if(sum<=threshold){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}