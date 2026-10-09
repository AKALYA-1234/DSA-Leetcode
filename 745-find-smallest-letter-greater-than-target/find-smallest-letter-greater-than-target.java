class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(letters[mid]<=target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        if(low>=n){
            return letters[0];
        }
        else{
            return letters[low];
        }
    }
}