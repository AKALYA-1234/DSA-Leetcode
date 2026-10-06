class Solution {
    public int minAddToMakeValid(String s) {
        int open=0;
        int close=0;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }
            else{
                if(!st.isEmpty()){
                    if(st.pop()=='('){
                    continue;
                }
                else{
                    open++;
                }
                }
                
            else{
                open++;
            }
            }
        }
        while(!st.isEmpty()){
            open++;
            st.pop();
        }
        return open;
    }
}