class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        int open=0;
        int close=0;
        int need=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                open++;
            }
            else{
                if(i+1<n&&s.charAt(i+1)==')'){
                    i=i+1;
                }
                else{
                    need++;
                }
                if(open>0){
                    open--;
                }
                else{
                    need++;
                }
            }
        }
        need=open*2+need;
        return need;
    }
}