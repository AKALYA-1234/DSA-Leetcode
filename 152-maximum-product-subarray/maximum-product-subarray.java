class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int leftprod=1;
        int rightprod=1;
        int ans=nums[0];
        for(int i=0;i<n;i++){
            if(leftprod==0){
                leftprod=1;
            }
            if(rightprod==0){
                rightprod=1;
            }
            leftprod*=nums[i];
            rightprod*=nums[n-i-1];
            ans=Math.max(ans,Math.max(leftprod,rightprod));
        }
        return ans;
    }
}