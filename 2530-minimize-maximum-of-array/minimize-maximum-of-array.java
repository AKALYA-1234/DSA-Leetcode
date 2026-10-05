class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n=nums.length;
        int[] ceil=new int[n];
        long prefixsum=0;
        for(int i=0;i<n;i++){
            prefixsum+=nums[i];
            ceil[i]=(int)Math.ceil((prefixsum+i)/(i+1));
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,ceil[i]);
        }
        return ans;
    }
}