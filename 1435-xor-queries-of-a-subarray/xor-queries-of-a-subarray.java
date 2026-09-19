class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n=arr.length;
        int a=queries.length;
        int[] ans=new int[a];
        int[] prefixsum=new int[n+1];
        for(int i=0;i<n;i++){
            prefixsum[i+1]=prefixsum[i]^arr[i];
        }
        for(int i=0;i<a;i++){
            int xor=0;
            int left=queries[i][0];
            int right=queries[i][1];
            ans[i]=prefixsum[right+1]^prefixsum[left];
        }
        return ans;
    }
}