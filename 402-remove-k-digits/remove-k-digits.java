class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        StringBuilder st=new StringBuilder();
        for(int i=0;i<n;i++){
            char curr=num.charAt(i);
            while(k>0&&st.length()>0&&(st.charAt(st.length()-1)>curr)){
                st.deleteCharAt(st.length()-1);
                k--;
            }
            st.append(curr);
        }
        while(k>0){
            st.deleteCharAt(st.length()-1);
            k--;
        }
        int i=0;
        while(i<st.length()&&st.charAt(i)=='0'){
            i++;
        }
        String ans=st.substring(i);
        if(ans.length()==0){
            return "0";
        }
        else{
            return ans;
        }
    }
}