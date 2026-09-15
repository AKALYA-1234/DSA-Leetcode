class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        int MOD=1000000007;
        long count=0;
        int even=1;
        int odd=0;
        int prefixsum=0;
        for(int i=0;i<n;i++){
            prefixsum+=arr[i];
            if(prefixsum%2==0){
                count+=odd;
                even++;
            }
            else{
                count+=even;
                odd++;
            }
            count=count%MOD;
        }
        return (int)count;
    }
}