class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int index=-1;
        int[] prefix=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        for(int i=0;i<n;i++){
            if(i==0){
                if((prefix[n-1]-prefix[0])==0){
                    return i;
                }
            }
            else if(i==n-1){
                if(prefix[n-2]==0){
                    return i;
                }
            }
            else{
                if(prefix[i-1]==prefix[n-1]-prefix[i]){
                   return i;
                }
            }
        }
        return index;
    }
}