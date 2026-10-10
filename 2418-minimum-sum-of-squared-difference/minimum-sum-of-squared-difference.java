class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n=nums1.length;
        int m=nums2.length;
        long sum=0;
        int[] freq=new int[100001];
        int maxdiff=0;
        long totaldiff=0;
        long k=(long) k1+k2;
        for(int i=0;i<n;i++){
            int diff=Math.abs(nums1[i]-nums2[i]);
            freq[diff]++;
            totaldiff+=diff;
            maxdiff=Math.max(maxdiff,diff);
        }
        if(totaldiff<=k){
            return 0;
        }
        for(int i=maxdiff;i>0&&k>0;i--){
            long moves=Math.min(freq[i],k);
            freq[i]-=(int)moves;
            freq[i-1]+=(int) moves;
            k-=moves;
        }
        for(int i=1;i<=maxdiff;i++){
            sum+=(long)i*i*freq[i];
        }
        return sum;
    }
}