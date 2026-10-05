class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n=nums.length;
        int[] ceil=new int[n];
        long prefixsum=0;
        int ans=0;
        for(int i=0;i<n;i++){
            prefixsum+=nums[i];
            int current=(int)((prefixsum+i)/(i+1));
            ans=Math.max(ans,current);
        }
        return ans;
    }
}