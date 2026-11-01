class Solution {
    public String largestOddNumber(String num) {
        int n=num.length();
        int last=0;
        int flag=0;
        for(int i=0;i<n;i++){
            int curr=num.charAt(i)-'0';
            if(curr%2!=0){
                flag=1;
                last=i;
            }
        }
        if(flag==0){
            return "";
        }
        return num.substring(0,last+1);
    }
}