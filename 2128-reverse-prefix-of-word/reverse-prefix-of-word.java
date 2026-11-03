class Solution {
    public String reversePrefix(String s, char ch) {
        int n=s.length();
        int index=0;
        int flag=0;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char curr=s.charAt(i);
            if(curr==ch){
                flag=1;
                st.push(curr);
                index=i+1;
                break;
            }
            else{
                st.push(curr);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        for(int i=index;i<n;i++){
            sb.append(s.charAt(i));
        }
        if(flag==0){
            return s;
        }
        return new String(sb);
    }
}