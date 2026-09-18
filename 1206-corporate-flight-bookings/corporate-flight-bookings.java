class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr=new int[n];
        int m=bookings.length;
        for(int i=0;i<m;i++){
            int first=bookings[i][0]-1;
            int last=bookings[i][1]-1;
            int seats=bookings[i][2];
            arr[first]+=seats;
            for(int j=first+1;j<=last;j++){
                arr[j]+=seats;
            }
        }
        return arr;
    }
}