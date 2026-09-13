class Solution {
    int prefix[][];
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int a=mat.length,b=mat[0].length;
        int[][] result=new int[a][b];
        prefix=new int[a][b];
        for(int i=0;i<a;i++){
            prefix[i][0]=mat[i][0];
        }
        for(int i=0;i<a;i++){
            for(int j=1;j<b;j++){
                prefix[i][j]=prefix[i][j-1]+mat[i][j];;
            }
        }
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                int top=Math.max(0,i-k);
                int bottom=Math.min(a-1,i+k);
                int left=Math.max(0,j-k);
                int right=Math.min(b-1,j+k);
                result[i][j]=matsum(top,left,bottom,right);
            }
        }
        return result;
    }
    int matsum(int row1,int col1,int row2,int col2){
        int sum=0;
        for(int i=row1;i<=row2;i++){
            if(col1==0){
                sum+=prefix[i][col2];
            }
            else{
                sum+=prefix[i][col2]-prefix[i][col1-1];
            }
        }
        return sum;
    }
}