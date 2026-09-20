class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int[] prefixsum=new int[n];
        prefixsum[0]=nums[0];
        for(int i=1;i<n;i++){
            prefixsum[i]=prefixsum[i-1]+nums[i];
        }
        for(int i=0;i<n;i++){
            if(i==0){
                if(prefixsum[n-1]-prefixsum[0]==0){
                    return i;
                }
            }
            else if(i==n-1){
                if(prefixsum[n-2]==0){
                    return i;
                }
            }
            else{
                if(prefixsum[i-1]==(prefixsum[n-1]-prefixsum[i])){
                    return i;
                }
            }
        }
        return -1;
    }
}