class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int low=0;
        int high=0;
        for(int i=0;i<n;i++){
            low=Math.max(low,weights[i]);
            high+=weights[i];
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int currentweight=0;
            int requiredweight=1;
            for(int i=0;i<n;i++){
                if(weights[i]+currentweight>mid){
                    requiredweight++;
                    currentweight=0;
                }
                currentweight+=weights[i];
            }
            if(requiredweight<=days){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}