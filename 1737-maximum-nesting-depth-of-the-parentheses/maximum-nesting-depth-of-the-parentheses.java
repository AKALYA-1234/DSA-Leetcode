class Solution {
    public int maxDepth(String s) {
        int n=s.length();
        int ans=0;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char curr=s.charAt(i);
            if(curr=='('){
                st.push(curr);
                ans=Math.max(ans,st.size());
            }
            else if(curr==')'){
                st.pop();
            }
        }
        return ans;
    }
}