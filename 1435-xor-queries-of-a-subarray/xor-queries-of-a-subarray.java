class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n=arr.length;
        int a=queries.length;
        int[] ans=new int[a];
        for(int i=0;i<a;i++){
            int xor=0;
            int left=queries[i][0];
            int right=queries[i][1];
            for(int j=left;j<=right;j++){
                xor^=arr[j];
            }
            ans[i]=xor;
        }
        return ans;
    }
}