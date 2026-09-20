class NumMatrix {
    int[][] prefixsum;
    public NumMatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        prefixsum=new int[n][m];
        for(int i=0;i<n;i++){
            prefixsum[i][0]=matrix[i][0];
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                prefixsum[i][j]=prefixsum[i][j-1]+matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        for(int i=row1;i<=row2;i++){
            if(col1==0){
                sum+=prefixsum[i][col2];
            }
            else{
                sum+=prefixsum[i][col2]-prefixsum[i][col1-1];
            }
        }
        return sum;
    }
}
