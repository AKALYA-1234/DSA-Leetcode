class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        int prod=1;
        for(int i=0;i<n;i++){
            left[i]=prod;
            prod*=nums[i];
        }
        int prod2=1;
        for(int i=n-1;i>=0;i--){
            right[i]=prod2;
            prod2*=nums[i];
        }
        for(int i=0;i<n;i++){
            nums[i]=left[i]*right[i];
        }
        return nums;
    }
}