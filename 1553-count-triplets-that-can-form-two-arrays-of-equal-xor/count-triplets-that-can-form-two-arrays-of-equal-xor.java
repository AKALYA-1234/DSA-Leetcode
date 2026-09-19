class Solution {
    public int countTriplets(int[] arr) {
        int n=arr.length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int a=0;
                int b=0;
                for(int k=i;k<j;k++){
                    a^=arr[k];
                }
                for(int k=j;k<n;k++){
                    b^=arr[k];
                    if(a==b){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}