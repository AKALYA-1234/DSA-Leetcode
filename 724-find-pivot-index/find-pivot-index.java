class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int sum=0;
            int sum1=0;
            for(int j=0;j<i;j++){
                sum+=nums[j];
            }
            for(int j=i+1;j<n;j++){
                sum1+=nums[j];
            }
            if(sum==sum1){
                return i;
            }
        }
        return -1;
    }
}