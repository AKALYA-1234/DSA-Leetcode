class Solution {
    public String clearDigits(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char curr=s.charAt(i);
            if(curr>='a'&&curr<='z'||curr>='A'&&curr<='Z'){
                st.push(curr);
            }
            else{
                if(!st.isEmpty()){
                    st.pop();
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return new String(sb.reverse());
    }
}