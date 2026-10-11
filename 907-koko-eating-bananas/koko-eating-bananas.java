class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,piles[i]);
        }
        long ans=0;
        int low=0,high=max;
        while(low<=high){
            int k=low+(high-low)/2;
            ans=0;
            for(int i=0;i<n;i++){
                ans+=Math.ceil((double)piles[i]/k);
            }
            if(ans<=h){
                high=k-1;
            }
            else{
                low=k+1;
            }
        }
        return low;
    }
}