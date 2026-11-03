class Solution {
    public String makeGood(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char curr=s.charAt(i);
            if(!st.isEmpty()&&Math.abs(st.peek()-curr)==32){
                st.pop();
            }
            else{
                st.push(curr);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return new String(sb.reverse());
    }
}