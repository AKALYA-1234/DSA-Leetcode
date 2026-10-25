class Solution {
    boolean is_palindrome(String s){
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
        String sub="";
        String maxword="";
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                sub=s.substring(i,j+1);
                if(is_palindrome(sub)){
                    if(sub.length()>max){
                        max=sub.length();
                        maxword=sub;
                    }
                }
            }
        }
        return maxword;
    }
}