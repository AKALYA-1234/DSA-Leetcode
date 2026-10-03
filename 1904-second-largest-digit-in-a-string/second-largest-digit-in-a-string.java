class Solution {
    boolean isDigit(char ch){
        return ch>='0' && ch<='9';
    }
    public int secondHighest(String s) {
        int count=0;
        int max=-1;
        int secmax=-1;
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(isDigit(curr)){
                int digit=curr-'0';
                if(digit>max){
                    secmax=max;
                    max=digit;
                }
                else if(digit>secmax&&digit!=max){
                    secmax=digit;
                }
            }
        }
        return secmax;
    }
}