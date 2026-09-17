class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n=trips.length;
        int[] dropping=new int[1001];
        for(int i=0;i<n;i++){
            int passenger=trips[i][0];
            int from=trips[i][1];
            int to=trips[i][2];
            dropping[from]+=passenger;
            dropping[to]-=passenger;
        }
        int sum=0;
        for(int i=0;i<1001;i++){
            sum+=dropping[i];
            if(sum>capacity){
                return false;
            }
        }
        return true;
    }
}