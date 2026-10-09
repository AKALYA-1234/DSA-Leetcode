class Solution {
    public boolean isPalindrome(String s){
            int n=s.length();
            int left=0;
            int right=n-1;
            while(left<=right){
                if(s.charAt(left)!=s.charAt(right)){
                    return false;
                }
                left++;
                right--;
            }
            return true;
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        int max=0;
        int start=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                String str=s.substring(i,j+1);
                if(isPalindrome(str)&&j-i+1>max){
                    max=j-i+1;
                    start=i;
                }
            }
        }
        return s.substring(start,start+max);
    }
}