class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        int asc=1;
        int dsc=1;
        int maxcount=1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                asc++;
                maxcount=Math.max(asc,maxcount);
            }
            else{
                asc=1;
            }
        }
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                dsc++;
                maxcount=Math.max(dsc,maxcount);
            }
            else{
                dsc=1;
            }
        }
        return maxcount;
    }
}