class Solution {
    public int minLength(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char curr=s.charAt(i);
            if(!st.isEmpty()&&(curr=='B'&&st.peek()=='A'||
               curr=='D'&&st.peek()=='C')){
                st.pop();
            }
            else{
                st.push(curr);
            }
        }
        return st.size();
    }
}