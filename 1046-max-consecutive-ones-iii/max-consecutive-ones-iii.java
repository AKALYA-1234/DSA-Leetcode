class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int max=0;
        int zero=0;
        for(int right=0;right<n;right++){
            int curr=nums[right];
            if(curr==0){
                zero++;
            }
            while(zero>k){
                if(nums[left]==0){
                    zero--;
                }
                left++;
            }
            if(right-left+1>max){
                max=right-left+1;
            }
        }
        return max;
    }
}