class Solution {
    public int countTriplets(int[] arr) {
        int n=arr.length;
        int[] prefixsum=new int[n+1];
        for(int i=0;i<n;i++){
            prefixsum[i+1]=prefixsum[i]^arr[i];
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int k=i+1;k<n;k++){
                if(prefixsum[i]==prefixsum[k+1]){
                    count+=k-i;
                }
            }
        }
        return count;
    }
}