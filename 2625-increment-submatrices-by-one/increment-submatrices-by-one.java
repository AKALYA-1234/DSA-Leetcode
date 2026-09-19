class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans=new int[n][n];
        int len=queries.length;
        for(int i=0;i<len;i++){
            int row1=queries[i][0];
            int col1=queries[i][1];
            int row2=queries[i][2];
            int col2=queries[i][3];
            for(int j=row1;j<=row2;j++){
                for(int k=col1;k<=col2;k++){
                    ans[j][k]+=1;
                }
            }
        }
        return ans;
    }
}