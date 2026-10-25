class Solution {
    public boolean validPalindrome(String s) {
        int n=s.length();
        int left=0;
        int right=n-1;
        while(left<=right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }
            else{
                int a=left+1;
                int b=right;
                boolean skipleft=true;
                while(a<=b){
                    if(s.charAt(a)!=s.charAt(b)){
                        skipleft=false;
                        break;
                    }
                    a++;
                    b--;
                }
                int p=left;
                int q=right-1;
                boolean skipright=true;
                while(p<=q){
                    if(s.charAt(p)!=s.charAt(q)){
                        skipright=false;
                        break;
                    }
                    p++;
                    q--;
                }
                return skipright||skipleft;
            }
        }
        return true;
    }
}