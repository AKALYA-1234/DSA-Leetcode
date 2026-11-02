class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int temp=n/2;
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.abs(nums[temp]-nums[i]);
        }
        return ans;
    }
}