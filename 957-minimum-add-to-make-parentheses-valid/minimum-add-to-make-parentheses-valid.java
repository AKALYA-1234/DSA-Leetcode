class Solution {
    public int minAddToMakeValid(String s) {
        int need=0;
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
                    need++;
                }
                }
                
            else{
                need++;
            }
            }
        }
        while(!st.isEmpty()){
            need++;
            st.pop();
        }
        return need;
    }
}