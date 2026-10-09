class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                return i;
            }
            else{
                if(nums[i]<target){
                    ans=i+1;
                }
            }
        }
        return ans;
    }
}